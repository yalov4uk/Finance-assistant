package com.perfect.team.business.validation;

import com.perfect.team.common.model.Transfer;
import com.perfect.team.business.validation.constraint.AccountId;
import com.perfect.team.business.validation.constraint.TransferId;
import com.perfect.team.business.validation.constraint.TransferUpdate;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransferUpdateValidator implements ConstraintValidator<TransferUpdate, Transfer> {

  @Inject
  private ConstraintValidator<TransferId, Long> transferIdValidator;

  @Inject
  private ConstraintValidator<AccountId, Long> accountIdValidator;

  @Override
  public void initialize(TransferUpdate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Transfer value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (!transferIdValidator.isValid(value.getId(), context)) {
      valid = false;
    }
    if (value.getFromAccount() != null && !accountIdValidator
        .isValid(value.getFromAccount().getId(), context)) {
      valid = false;
    }
    if (value.getToAccount() != null && !accountIdValidator
        .isValid(value.getToAccount().getId(), context)) {
      valid = false;
    }
    return valid;
  }
}
