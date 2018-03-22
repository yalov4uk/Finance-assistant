package com.perfect.team.service.validation;

import com.perfect.team.service.request.UserUpdateRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserUpdateValidator implements ConstraintValidator<UserUpdate, UserUpdateRequest> {
    @Override
    public void initialize(UserUpdate constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserUpdateRequest value, ConstraintValidatorContext context) {
        return false;
    }
}
