package com.perfect.team.service.validation;

import com.perfect.team.service.request.SignInRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SignInValidator implements ConstraintValidator<SignIn, SignInRequest> {
    @Override
    public void initialize(SignIn constraintAnnotation) {

    }

    @Override
    public boolean isValid(SignInRequest value, ConstraintValidatorContext context) {
        return false;
    }
}
