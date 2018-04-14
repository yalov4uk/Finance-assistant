package com.perfect.team.business.validation;

import com.perfect.team.business.model.User;
import com.perfect.team.business.validation.constraint.SignUp;
import com.perfect.team.business.validation.constraint.UserCreate;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class SignUpValidator implements ConstraintValidator<SignUp, User> {

  @Inject
  private ConstraintValidator<UserCreate, User> userCreateValidator;

  @Override
  public void initialize(SignUp constraintAnnotation) {
  }

  @Override
  public boolean isValid(User value, ConstraintValidatorContext context) {
    boolean valid = true;
    valid = userCreateValidator.isValid(value, context);
    return valid;
  }
}
