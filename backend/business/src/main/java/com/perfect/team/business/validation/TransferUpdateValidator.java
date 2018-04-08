package com.perfect.team.business.validation;

import com.perfect.team.business.model.Transfer;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransferUpdateValidator implements ConstraintValidator<TransferUpdate, Transfer> {

  @Override
  public void initialize(TransferUpdate constraintAnnotation) {

  }

  @Override
  public boolean isValid(Transfer value, ConstraintValidatorContext context) {
    return true;
  }
}
