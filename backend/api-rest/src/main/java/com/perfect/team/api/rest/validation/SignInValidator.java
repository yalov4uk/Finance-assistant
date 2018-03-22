package com.perfect.team.api.rest.validation;

import com.perfect.team.api.rest.request.SignInRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SignInValidator implements ConstraintValidator<SignIn, SignInRequest> {

    @Override
    public void initialize(SignIn constraintAnnotation) {
    }

    @Override
    public boolean isValid(SignInRequest value, ConstraintValidatorContext context) {
        return value.getEmail() != null && value.getPassword() != null || value.getToken() != null;
    }
}
