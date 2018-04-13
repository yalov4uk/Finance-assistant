package com.perfect.team.business.validation;

import com.perfect.team.business.model.Category;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class CategoryUpdateValidator implements ConstraintValidator<CategoryUpdate, Category> {

  @Inject
  private ConstraintValidator<CategoryId, Long> categoryIdValidator;

  @Override
  public void initialize(CategoryUpdate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Category value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (!categoryIdValidator.isValid(value.getId(), context)) {
      valid = false;
    }
    return valid;
  }
}
