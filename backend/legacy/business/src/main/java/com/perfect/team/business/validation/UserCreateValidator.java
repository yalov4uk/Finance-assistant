package com.perfect.team.business.validation;

import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.validation.constraint.UserCreate;
import com.perfect.team.common.model.User;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UserCreateValidator implements ConstraintValidator<UserCreate, User> {

  @Inject
  private UserMapper userMapper;

  @Override
  public void initialize(UserCreate constraintAnnotation) {
  }

  @Override
  public boolean isValid(User value, ConstraintValidatorContext context) {
    boolean valid = true;
//    if (!userMapper.select(null, null, value.getEmail()).isEmpty()) {
//      valid = false;
//      context.buildConstraintViolationWithTemplate("Email already in use").addConstraintViolation();
//    }
    return valid;
  }
}
