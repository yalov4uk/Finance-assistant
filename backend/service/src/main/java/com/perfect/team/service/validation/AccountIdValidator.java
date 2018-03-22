package com.perfect.team.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountIdValidator implements ConstraintValidator<AccountId, Long> {
    @Override
    public void initialize(AccountId constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return false;
    }
}
