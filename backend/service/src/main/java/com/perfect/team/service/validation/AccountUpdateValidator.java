package com.perfect.team.service.validation;

import com.perfect.team.service.request.AccountUpdateRequest;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class AccountUpdateValidator implements
    ConstraintValidator<AccountUpdate, AccountUpdateRequest> {

  @Inject
  private AccountIdValidator accountIdValidator;

  @Override
  public void initialize(AccountUpdate constraintAnnotation) {

  }

  @Override
  public boolean isValid(AccountUpdateRequest value, ConstraintValidatorContext context) {
    boolean result = accountIdValidator.isValid(value, context);
    return true;
  }
}
