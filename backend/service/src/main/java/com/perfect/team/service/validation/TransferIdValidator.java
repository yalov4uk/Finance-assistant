package com.perfect.team.service.validation;

import com.perfect.team.service.request.IdRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransferIdValidator implements ConstraintValidator<TransferId, IdRequest> {

  @Override
  public void initialize(TransferId constraintAnnotation) {

  }

  @Override
  public boolean isValid(IdRequest value, ConstraintValidatorContext context) {
    return true;
  }
}
