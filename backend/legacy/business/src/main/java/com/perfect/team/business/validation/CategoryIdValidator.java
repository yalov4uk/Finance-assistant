package com.perfect.team.business.validation;

import com.perfect.team.business.mapper.CategoryMapper;
import com.perfect.team.business.validation.constraint.CategoryId;
import com.perfect.team.common.model.Category;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class CategoryIdValidator implements ConstraintValidator<CategoryId, Long> {

  @Inject
  private CategoryMapper categoryMapper;

//  @Inject
//  private ConstraintValidator<UserId, Long> userIdValidator;

  @Override
  public void initialize(CategoryId constraintAnnotation) {
  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    boolean valid = true;
    Category category = categoryMapper.selectById(value);
    if (category == null) {
      valid = false;
      context.buildConstraintViolationWithTemplate("Category not found").addConstraintViolation();
    }
//    if (category != null && category.getUser() != null && !userIdValidator
//        .isValid(category.getUser().getId(), context)) {
//      valid = false;
//    }
    return valid;
  }
}
