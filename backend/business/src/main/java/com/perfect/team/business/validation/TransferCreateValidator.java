package com.perfect.team.business.validation;

import com.perfect.team.business.model.Transfer;
import com.perfect.team.business.validation.constraint.AccountId;
import com.perfect.team.business.validation.constraint.TransferCreate;
import com.perfect.team.business.validation.constraint.UserId;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransferCreateValidator implements ConstraintValidator<TransferCreate, Transfer> {

  @Inject
  private ConstraintValidator<UserId, Long> userIdValidator;

  @Inject
  private ConstraintValidator<AccountId, Long> accountIdValidator;

  @Override
  public void initialize(TransferCreate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Transfer value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (value.getFromAccount() != null && !accountIdValidator
        .isValid(value.getFromAccount().getId(), context)) {
      valid = false;
    }
    if (value.getToAccount() != null && !accountIdValidator
        .isValid(value.getToAccount().getId(), context)) {
      valid = false;
    }
    if (value.getUser() != null && !userIdValidator.isValid(value.getUser().getId(), context)) {
      valid = false;
    }
    return valid;
  }
}
