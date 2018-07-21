package com.perfect.team.business.validation;

import com.perfect.team.common.model.Account;
import com.perfect.team.business.validation.constraint.AccountCreate;
import com.perfect.team.business.validation.constraint.UserId;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class AccountCreateValidator implements ConstraintValidator<AccountCreate, Account> {

  @Inject
  private ConstraintValidator<UserId, Long> userIdValidator;

  @Override
  public void initialize(AccountCreate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Account value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (value.getUser() != null && !userIdValidator.isValid(value.getUser().getId(), context)) {
      valid = false;
    }
    return valid;
  }
}
