package com.perfect.team.service.validation;

import com.perfect.team.service.request.TransactionCreateRequest;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class TransactionCreateValidator implements
    ConstraintValidator<TransactionCreate, TransactionCreateRequest> {

  @Override
  public void initialize(TransactionCreate constraintAnnotation) {

  }

  @Override
  public boolean isValid(TransactionCreateRequest value, ConstraintValidatorContext context) {
    return true;
  }
}
