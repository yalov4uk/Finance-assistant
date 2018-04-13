package com.perfect.team.business.validation;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UserIdOrNullValidator implements ConstraintValidator<UserIdOrNull, Long> {

  @Inject
  private ConstraintValidator<UserId, Long> userIdValidator;

  @Override
  public void initialize(UserIdOrNull constraintAnnotation) {
  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (value != null && !userIdValidator.isValid(value, context)) {
      valid = false;
    }
    return valid;
  }
}
