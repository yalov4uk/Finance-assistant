package com.perfect.team.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TransactionIdValidator implements ConstraintValidator<TransactionId, Long> {
    @Override
    public void initialize(TransactionId constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return false;
    }
}
