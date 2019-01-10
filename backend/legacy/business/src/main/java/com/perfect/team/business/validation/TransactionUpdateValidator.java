package com.perfect.team.business.validation;

import com.perfect.team.business.validation.constraint.AccountId;
import com.perfect.team.business.validation.constraint.CategoryId;
import com.perfect.team.business.validation.constraint.TransactionId;
import com.perfect.team.business.validation.constraint.TransactionUpdate;
import com.perfect.team.common.model.Transaction;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransactionUpdateValidator implements
    ConstraintValidator<TransactionUpdate, Transaction> {

  @Inject
  private ConstraintValidator<TransactionId, Long> transactionIdValidator;

  @Inject
  private ConstraintValidator<AccountId, Long> accountIdValidator;

  @Inject
  private ConstraintValidator<CategoryId, Long> categoryIdValidator;

  @Override
  public void initialize(TransactionUpdate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Transaction value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (!transactionIdValidator.isValid(value.getId(), context)) {
      valid = false;
    }
    if (value.getAccount() != null && !accountIdValidator
        .isValid(value.getAccount().getId(), context)) {
      valid = false;
    }
    if (value.getCategory() != null && !categoryIdValidator
        .isValid(value.getCategory().getId(), context)) {
      valid = false;
    }
    return valid;
  }
}
