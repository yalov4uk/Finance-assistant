package com.perfect.team.business.validation;

import com.perfect.team.business.validation.constraint.TransferId;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransferIdValidator implements ConstraintValidator<TransferId, Long> {

  @Override
  public void initialize(TransferId constraintAnnotation) {
  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    return true;
  }
}
