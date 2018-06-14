package com.perfect.team.business.validation;

import com.perfect.team.business.mapper.ConfirmationMapper;
import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.model.Confirmation;
import com.perfect.team.business.validation.constraint.ConfirmationUpdate;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationUpdateValidator implements
    ConstraintValidator<ConfirmationUpdate, Confirmation> {

  @Inject
  private ConfirmationMapper confirmationMapper;

  @Inject
  private UserMapper userMapper;

  @Override
  public void initialize(ConfirmationUpdate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Confirmation value, ConstraintValidatorContext context) {
    Confirmation confirmation = confirmationMapper
        .selectByCodeAndUserId(value.getCode(), value.getUser().getId());
    if (confirmation == null) {
      context.buildConstraintViolationWithTemplate("Confirmation not found")
          .addConstraintViolation();
      return false;
    }
    if (confirmation.getConfirmed()
        || userMapper.selectById(value.getUser().getId()).getConfirmed()) {
      context.buildConstraintViolationWithTemplate("User already confirmed")
          .addConstraintViolation();
      return false;
    }
    return true;
  }
}
