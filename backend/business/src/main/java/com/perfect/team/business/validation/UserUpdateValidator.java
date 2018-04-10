package com.perfect.team.business.validation;

import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.model.User;
import com.perfect.team.business.service.UserService;
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
    valid = userIdValidator.isValid(value.getId(), context);
    if (value.getEmail() != null && userMapper.selectByEmail(value.getEmail()) != null) {
      valid = false;
      context.buildConstraintViolationWithTemplate("Email already in use").addConstraintViolation();
    }
    return valid;
  }
}
