package com.perfect.team.service.validation;

import com.perfect.team.service.request.IdRequest;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UserIdValidator implements ConstraintValidator<UserId, IdRequest> {
    @Override
    public void initialize(UserId constraintAnnotation) {

    }

    @Override
    public boolean isValid(IdRequest value, ConstraintValidatorContext context) {
        return true;
    }
}
