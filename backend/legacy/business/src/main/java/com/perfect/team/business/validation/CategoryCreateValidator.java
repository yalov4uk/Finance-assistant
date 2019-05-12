package com.perfect.team.business.validation;

import com.perfect.team.business.validation.constraint.CategoryCreate;
import com.perfect.team.common.model.Category;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class CategoryCreateValidator implements ConstraintValidator<CategoryCreate, Category> {

//  @Inject
//  private ConstraintValidator<UserId, Long> userIdValidator;

  @Override
  public void initialize(CategoryCreate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Category value, ConstraintValidatorContext context) {
    boolean valid = true;
//    if (value.getUser() != null && !userIdValidator.isValid(value.getUser().getId(), context)) {
//      valid = false;
//    }
    return valid;
  }
}
