package com.perfect.team.business.validation;

import com.perfect.team.common.model.Confirmation;
import com.perfect.team.business.validation.constraint.ConfirmationCreate;
import com.perfect.team.business.validation.constraint.UserId;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationCreateValidator implements
    ConstraintValidator<ConfirmationCreate, Confirmation> {

  @Inject
  private ConstraintValidator<UserId, Long> userIdValidator;

  @Override
  public void initialize(ConfirmationCreate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Confirmation value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (value.getUser() != null && !userIdValidator.isValid(value.getUser().getId(), context)) {
      valid = false;
    }
    return valid;
  }
}
