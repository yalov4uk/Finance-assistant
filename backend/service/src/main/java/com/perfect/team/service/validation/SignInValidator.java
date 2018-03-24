package com.perfect.team.service.validation;

import com.perfect.team.service.request.SignInRequest;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class SignInValidator implements ConstraintValidator<SignIn, SignInRequest> {
    @Override
    public void initialize(SignIn constraintAnnotation) {

    }

    @Override
    public boolean isValid(SignInRequest value, ConstraintValidatorContext context) {
        return true;
    }
}
