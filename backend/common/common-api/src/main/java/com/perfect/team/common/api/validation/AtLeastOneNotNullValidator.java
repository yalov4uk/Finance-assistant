package com.perfect.team.common.api.validation;

import com.perfect.team.common.api.validation.constraint.AtLeastOneNotNull;
import java.lang.reflect.InvocationTargetException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;

@Slf4j
public class AtLeastOneNotNullValidator implements ConstraintValidator<AtLeastOneNotNull, Object> {

  private String[] fieldNames;

  @Override
  public void initialize(AtLeastOneNotNull constraintAnnotation) {
    fieldNames = constraintAnnotation.fieldNames();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    for (String fieldName : fieldNames) {
      try {
        if (PropertyUtils.getProperty(value, fieldName) != null) {
          return true;
        }
      } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        log.error("No field {} in type {}", fieldName, value.getClass());
      }
    }
    return false;
  }
}
