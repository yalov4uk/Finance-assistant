package com.perfect.team.service.validation;

import com.perfect.team.service.request.CategoryCreateRequest;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CategoryUpdateValidator implements ConstraintValidator<CategoryCreate, CategoryCreateRequest> {
    @Override
    public void initialize(CategoryCreate constraintAnnotation) {

    }

    @Override
    public boolean isValid(CategoryCreateRequest value, ConstraintValidatorContext context) {
        return true;
    }
}
