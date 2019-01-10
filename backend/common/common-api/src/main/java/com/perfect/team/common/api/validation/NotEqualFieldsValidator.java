package com.perfect.team.common.api.validation;

import com.perfect.team.common.api.validation.constraint.NotEqualFields;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;

@Slf4j
public class NotEqualFieldsValidator implements ConstraintValidator<NotEqualFields, Object> {

  private String[] fieldNames;

  @Override
  public void initialize(NotEqualFields constraintAnnotation) {
    fieldNames = constraintAnnotation.fieldNames();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    return Arrays.stream(fieldNames).map(fieldName -> {
      try {
        return PropertyUtils.getProperty(value, fieldName);
      } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        log.error("No field {} in type {}", fieldName, value.getClass());
        return null;
      }
    }).distinct().count() > 1;
  }
}
