package com.perfect.team.business.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransactionIdValidator implements ConstraintValidator<TransactionId, Long> {

  @Override
  public void initialize(TransactionId constraintAnnotation) {

  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    return true;
  }
}
