package com.perfect.team.business.validation;

import com.perfect.team.business.model.User;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserCreateValidator implements ConstraintValidator<UserCreate, User> {

  @Override
  public void initialize(UserCreate constraintAnnotation) {
  }

  @Override
  public boolean isValid(User value, ConstraintValidatorContext context) {
    return true;
  }
}
