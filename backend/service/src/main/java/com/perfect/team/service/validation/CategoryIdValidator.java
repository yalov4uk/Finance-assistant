package com.perfect.team.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryIdValidator implements ConstraintValidator<CategoryId, Long> {
    @Override
    public void initialize(CategoryId constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return false;
    }
}
