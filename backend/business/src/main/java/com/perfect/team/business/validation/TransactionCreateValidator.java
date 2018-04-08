package com.perfect.team.business.validation;

import com.perfect.team.business.model.Transaction;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransactionCreateValidator implements
    ConstraintValidator<TransactionCreate, Transaction> {

  @Override
  public void initialize(TransactionCreate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Transaction value, ConstraintValidatorContext context) {
    return true;
  }
}
