package com.perfect.team.business.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class AccountIdValidator implements ConstraintValidator<AccountId, Long> {

  @Override
  public void initialize(AccountId constraintAnnotation) {
  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    return true;
  }
}
