package com.perfect.team.business.validation;

import com.perfect.team.business.model.Category;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class CategoryCreateValidator implements ConstraintValidator<CategoryCreate, Category> {

  @Override
  public void initialize(CategoryCreate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Category value, ConstraintValidatorContext context) {
    return true;
  }
}
