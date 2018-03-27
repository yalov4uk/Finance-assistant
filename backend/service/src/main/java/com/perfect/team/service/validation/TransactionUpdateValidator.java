package com.perfect.team.service.validation;

import com.perfect.team.service.request.TransactionUpdateRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransactionUpdateValidator implements
    ConstraintValidator<TransactionUpdate, TransactionUpdateRequest> {

  @Override
  public void initialize(TransactionUpdate constraintAnnotation) {

  }

  @Override
  public boolean isValid(TransactionUpdateRequest value, ConstraintValidatorContext context) {
    return true;
  }
}
