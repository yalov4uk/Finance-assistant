package com.perfect.team.business.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UserIdValidator implements ConstraintValidator<UserId, Long> {

  @Override
  public void initialize(UserId constraintAnnotation) {

  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    return true;
  }
}
