package com.perfect.team.service.validation;

import com.perfect.team.service.request.TransferCreateRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransferCreateValidator implements
    ConstraintValidator<TransferCreate, TransferCreateRequest> {

  @Override
  public void initialize(TransferCreate constraintAnnotation) {

  }

  @Override
  public boolean isValid(TransferCreateRequest value, ConstraintValidatorContext context) {
    return true;
  }
}
