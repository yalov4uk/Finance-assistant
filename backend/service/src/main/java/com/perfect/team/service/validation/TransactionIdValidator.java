package com.perfect.team.service.validation;

import com.perfect.team.service.request.IdRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransactionIdValidator implements ConstraintValidator<TransactionId, IdRequest> {

  @Override
  public void initialize(TransactionId constraintAnnotation) {

  }

  @Override
  public boolean isValid(IdRequest value, ConstraintValidatorContext context) {
    return true;
  }
}
