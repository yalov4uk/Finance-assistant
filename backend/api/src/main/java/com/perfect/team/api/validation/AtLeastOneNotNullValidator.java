package com.perfect.team.api.validation;

import com.perfect.team.api.validation.constraint.AtLeastOneNotNull;
import java.lang.reflect.InvocationTargetException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AtLeastOneNotNullValidator implements ConstraintValidator<AtLeastOneNotNull, Object> {

  private static final Logger logger = LoggerFactory.getLogger(AtLeastOneNotNullValidator.class);

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
        logger.error("No field {} in type {}", fieldName, value.getClass());
      }
    }
    return false;
  }
}
