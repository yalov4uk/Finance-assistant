package com.perfect.team.service.validation;

import com.perfect.team.service.request.CategoryCreateRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryUpdateValidator implements ConstraintValidator<CategoryCreate, CategoryCreateRequest> {
    @Override
    public void initialize(CategoryCreate constraintAnnotation) {

    }

    @Override
    public boolean isValid(CategoryCreateRequest value, ConstraintValidatorContext context) {
        return false;
    }
}
