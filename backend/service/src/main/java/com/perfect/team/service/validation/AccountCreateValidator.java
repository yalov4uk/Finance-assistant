package com.perfect.team.service.validation;

import com.perfect.team.service.request.AccountCreateRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class AccountCreateValidator implements
    ConstraintValidator<AccountCreate, AccountCreateRequest> {

  @Override
  public void initialize(AccountCreate constraintAnnotation) {
  }

  @Override
  public boolean isValid(AccountCreateRequest value, ConstraintValidatorContext context) {
    return true;
  }
}
