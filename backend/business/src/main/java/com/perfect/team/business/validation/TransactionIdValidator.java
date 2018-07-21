package com.perfect.team.business.validation;

import com.perfect.team.business.mapper.TransactionMapper;
import com.perfect.team.common.model.Transaction;
import com.perfect.team.business.validation.constraint.TransactionId;
import com.perfect.team.business.validation.constraint.UserId;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TransactionIdValidator implements ConstraintValidator<TransactionId, Long> {

  @Inject
  private TransactionMapper transactionMapper;

  @Inject
  private ConstraintValidator<UserId, Long> userIdValidator;

  @Override
  public void initialize(TransactionId constraintAnnotation) {
  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    boolean valid = true;
    Transaction transaction = transactionMapper.selectById(value);
    if (transaction == null) {
      valid = false;
      context.buildConstraintViolationWithTemplate("Transaction not found")
          .addConstraintViolation();
    }
    if (transaction != null && transaction.getUser() != null && !userIdValidator
        .isValid(transaction.getUser().getId(), context)) {
      valid = false;
    }
    return valid;
  }
}
