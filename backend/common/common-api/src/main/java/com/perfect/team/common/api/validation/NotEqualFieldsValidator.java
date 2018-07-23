package com.perfect.team.common.api.validation;

import com.perfect.team.common.api.validation.constraint.NotEqualFields;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotEqualFieldsValidator implements ConstraintValidator<NotEqualFields, Object> {

  private static final Logger logger = LoggerFactory.getLogger(NotEqualFieldsValidator.class);

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
        logger.error("No field {} in type {}", fieldName, value.getClass());
        return null;
      }
    }).distinct().count() > 1;
  }
}
