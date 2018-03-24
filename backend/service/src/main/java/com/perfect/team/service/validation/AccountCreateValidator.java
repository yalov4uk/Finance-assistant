package com.perfect.team.service.validation;

import com.perfect.team.service.request.AccountCreateRequest;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class AccountCreateValidator implements ConstraintValidator<AccountCreate, AccountCreateRequest> {
    @Override
    public void initialize(AccountCreate constraintAnnotation) {
    }

    @Override
    public boolean isValid(AccountCreateRequest value, ConstraintValidatorContext context) {
        return true;
    }
}
