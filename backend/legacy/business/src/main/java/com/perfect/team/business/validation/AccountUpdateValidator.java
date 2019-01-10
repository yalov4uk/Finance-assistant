package com.perfect.team.business.validation;

import com.perfect.team.business.validation.constraint.AccountId;
import com.perfect.team.business.validation.constraint.AccountUpdate;
import com.perfect.team.common.model.Account;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class AccountUpdateValidator implements ConstraintValidator<AccountUpdate, Account> {

  @Inject
  private ConstraintValidator<AccountId, Long> accountIdValidator;

  @Override
  public void initialize(AccountUpdate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Account value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (!accountIdValidator.isValid(value.getId(), context)) {
      valid = false;
    }
    return valid;
  }
}