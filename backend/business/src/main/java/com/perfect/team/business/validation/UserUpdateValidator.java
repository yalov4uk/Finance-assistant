package com.perfect.team.business.validation;

import com.perfect.team.business.model.User;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateValidator implements ConstraintValidator<UserUpdate, User> {

  @Override
  public void initialize(UserUpdate constraintAnnotation) {
  }

  @Override
  public boolean isValid(User value, ConstraintValidatorContext context) {
    return true;
  }
}
