package com.perfect.team.user.imp.validation;

import com.perfect.team.user.imp.model.User;
import com.perfect.team.user.imp.validation.constraint.UserId;
import com.perfect.team.user.imp.validation.constraint.UserRead;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserReadValidator implements ConstraintValidator<UserRead, User> {

  private final ConstraintValidator<UserId, Long> userIdValidator;

  @Override
  public boolean isValid(User value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (value.getId() != null && !userIdValidator.isValid(value.getId(), context)) {
      valid = false;
    }
    return valid;
  }
}
