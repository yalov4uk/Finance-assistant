package com.perfect.team.service.validation;

import com.perfect.team.service.request.TransactionUpdateRequest;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class TransferUpdateValidator implements ConstraintValidator<TransferUpdate, TransactionUpdateRequest> {
    @Override
    public void initialize(TransferUpdate constraintAnnotation) {

    }

    @Override
    public boolean isValid(TransactionUpdateRequest value, ConstraintValidatorContext context) {
        return true;
    }
}
