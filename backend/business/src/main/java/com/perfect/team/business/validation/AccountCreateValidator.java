package com.perfect.team.business.validation;

import com.perfect.team.business.model.Account;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class AccountCreateValidator implements ConstraintValidator<AccountCreate, Account> {

  @Override
  public void initialize(AccountCreate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Account value, ConstraintValidatorContext context) {
    return true;
  }
}
