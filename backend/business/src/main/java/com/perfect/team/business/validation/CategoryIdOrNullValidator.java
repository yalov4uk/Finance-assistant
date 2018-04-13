package com.perfect.team.business.validation;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class CategoryIdOrNullValidator implements ConstraintValidator<CategoryIdOrNull, Long> {

  @Inject
  private ConstraintValidator<CategoryId, Long> categoryIdValidator;

  @Override
  public void initialize(CategoryIdOrNull constraintAnnotation) {
  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (value != null && !categoryIdValidator.isValid(value, context)) {
      valid = false;
    }
    return valid;
  }
}
