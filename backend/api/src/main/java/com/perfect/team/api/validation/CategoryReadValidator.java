package com.perfect.team.api.validation;

import com.perfect.team.api.validation.constraint.CategoryRead;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import org.springframework.stereotype.Component;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
@Component
public class CategoryReadValidator implements ConstraintValidator<CategoryRead, Object[]> {

  @Override
  public void initialize(CategoryRead constraintAnnotation) {
  }

  @Override
  public boolean isValid(Object[] value, ConstraintValidatorContext context) {
    boolean valid = true;
    Long id = (Long) value[0];
    Long userId = (Long) value[1];
    if (id == null && userId == null) {
      valid = false;
      context.buildConstraintViolationWithTemplate("Id or userId required")
          .addConstraintViolation();
    }
    return valid;
  }
}
