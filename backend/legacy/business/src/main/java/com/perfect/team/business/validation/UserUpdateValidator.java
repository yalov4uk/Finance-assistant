package com.perfect.team.business.validation;

import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.validation.constraint.UserId;
import com.perfect.team.business.validation.constraint.UserUpdate;
import com.perfect.team.common.model.User;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateValidator implements ConstraintValidator<UserUpdate, User> {

  @Inject
  private UserMapper userMapper;

  @Inject
  private ConstraintValidator<UserId, Long> userIdValidator;

  @Override
  public void initialize(UserUpdate constraintAnnotation) {
  }

  @Override
  public boolean isValid(User value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (!userIdValidator.isValid(value.getId(), context)) {
      valid = false;
    }
//    if (value.getEmail() != null && !userMapper.select(null, null, value.getEmail()).isEmpty()) {
//      valid = false;
//      context.buildConstraintViolationWithTemplate("Email already in use").addConstraintViolation();
//    }
    return valid;
  }
}
