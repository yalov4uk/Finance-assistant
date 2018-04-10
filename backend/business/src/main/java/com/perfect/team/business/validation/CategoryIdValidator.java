package com.perfect.team.business.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class CategoryIdValidator implements ConstraintValidator<CategoryId, Long> {

  @Override
  public void initialize(CategoryId constraintAnnotation) {
  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    return true;
  }
}