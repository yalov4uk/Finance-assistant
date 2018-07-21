package com.perfect.team.business.validation;

import com.perfect.team.business.mapper.TransferMapper;
import com.perfect.team.common.model.Transfer;
import com.perfect.team.business.validation.constraint.TransferId;
import com.perfect.team.business.validation.constraint.UserId;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransferIdValidator implements ConstraintValidator<TransferId, Long> {

  @Inject
  private TransferMapper transferMapper;

  @Inject
  private ConstraintValidator<UserId, Long> userIdValidator;

  @Override
  public void initialize(TransferId constraintAnnotation) {
  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    boolean valid = true;
    Transfer transfer = transferMapper.selectById(value);
    if (transfer == null) {
      valid = false;
      context.buildConstraintViolationWithTemplate("Transfer not found")
          .addConstraintViolation();
    }
    if (transfer != null && transfer.getUser() != null && !userIdValidator
        .isValid(transfer.getUser().getId(), context)) {
      valid = false;
    }
    return valid;
  }
}
