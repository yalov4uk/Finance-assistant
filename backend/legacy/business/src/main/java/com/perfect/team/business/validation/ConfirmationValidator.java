package com.perfect.team.business.validation;

import com.perfect.team.business.mapper.ConfirmationMapper;
import com.perfect.team.business.validation.constraint.ConfirmationConfirm;
import com.perfect.team.common.model.Confirmation;
import java.util.Objects;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationValidator implements
    ConstraintValidator<ConfirmationConfirm, Confirmation> {

  @Inject
  private ConfirmationMapper confirmationMapper;

  @Override
  public void initialize(ConfirmationConfirm constraintAnnotation) {
  }

  @Override
  public boolean isValid(Confirmation value, ConstraintValidatorContext context) {
    boolean valid = true;
    Confirmation confirmation = confirmationMapper.selectById(value.getId());
    if (confirmation == null
        || !Objects.equals(confirmation.getUser().getId(), value.getUser().getId())) {
      context.buildConstraintViolationWithTemplate("Confirmation not found")
          .addConstraintViolation();
      valid = false;
    }
    if (!Objects.equals(confirmation.getCode(), value.getCode())) {
      context.buildConstraintViolationWithTemplate("Wrong confirmation code")
          .addConstraintViolation();
      valid = false;
    }
    return valid;
  }
}
