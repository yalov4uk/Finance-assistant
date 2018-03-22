package com.perfect.team.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TransferIdValidator implements ConstraintValidator<TransferId, Long> {
    @Override
    public void initialize(TransferId constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return false;
    }
}
