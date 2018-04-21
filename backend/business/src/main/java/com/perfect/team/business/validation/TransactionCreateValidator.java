package com.perfect.team.business.validation;

import com.perfect.team.business.model.Transaction;
import com.perfect.team.business.validation.constraint.AccountId;
import com.perfect.team.business.validation.constraint.CategoryId;
import com.perfect.team.business.validation.constraint.TransactionCreate;
import com.perfect.team.business.validation.constraint.UserId;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransactionCreateValidator implements
    ConstraintValidator<TransactionCreate, Transaction> {

  @Inject
  private ConstraintValidator<UserId, Long> userIdValidator;

  @Inject
  private ConstraintValidator<AccountId, Long> accountIdValidator;

  @Inject
  private ConstraintValidator<CategoryId, Long> categoryIdValidator;

  @Override
  public void initialize(TransactionCreate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Transaction value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (value.getAccount() != null && !accountIdValidator
        .isValid(value.getAccount().getId(), context)) {
      valid = false;
    }
    if (value.getCategory() != null && !categoryIdValidator
        .isValid(value.getCategory().getId(), context)) {
      valid = false;
    }
    if (value.getUser() != null && !userIdValidator.isValid(value.getUser().getId(), context)) {
      valid = false;
    }
    return valid;
  }
}
