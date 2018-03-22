package com.perfect.team.service.validation;

import com.perfect.team.service.request.TransactionCreateRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TransactionCreateValidator implements ConstraintValidator<TransactionCreate, TransactionCreateRequest> {
    @Override
    public void initialize(TransactionCreate constraintAnnotation) {

    }

    @Override
    public boolean isValid(TransactionCreateRequest value, ConstraintValidatorContext context) {
        return false;
    }
}
