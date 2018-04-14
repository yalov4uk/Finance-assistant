package com.perfect.team.business.validation;

import com.perfect.team.business.model.Transfer;
import com.perfect.team.business.validation.constraint.TransferCreate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransferCreateValidator implements ConstraintValidator<TransferCreate, Transfer> {

  @Override
  public void initialize(TransferCreate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Transfer value, ConstraintValidatorContext context) {
    return true;
  }
}
