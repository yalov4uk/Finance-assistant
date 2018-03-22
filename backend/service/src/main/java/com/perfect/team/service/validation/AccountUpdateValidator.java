package com.perfect.team.service.validation;

import com.perfect.team.service.request.AccountUpdateRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountUpdateValidator implements ConstraintValidator<AccountUpdate, AccountUpdateRequest> {
    @Override
    public void initialize(AccountUpdate constraintAnnotation) {

    }

    @Override
    public boolean isValid(AccountUpdateRequest value, ConstraintValidatorContext context) {
        return false;
    }
}
