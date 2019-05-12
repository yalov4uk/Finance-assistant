package com.perfect.team.business.validation;

import com.perfect.team.business.mapper.AccountMapper;
import com.perfect.team.business.validation.constraint.AccountId;
import com.perfect.team.common.model.Account;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class AccountIdValidator implements ConstraintValidator<AccountId, Long> {

  @Inject
  private AccountMapper accountMapper;

//  @Inject
//  private ConstraintValidator<UserId, Long> userIdValidator;

  @Override
  public void initialize(AccountId constraintAnnotation) {
  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    boolean valid = true;
    if (accountMapper.selectById(value) == null) {
      valid = false;
      context.buildConstraintViolationWithTemplate("Account not found").addConstraintViolation();
    }
    Account account = accountMapper.selectById(value);
//    if (account != null && account.getUser() != null && !userIdValidator
//        .isValid(account.getUser().getId(), context)) {
//      valid = false;
//    }
    return valid;
  }
}
