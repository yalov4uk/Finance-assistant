package com.perfect.team.business.validation;

import com.perfect.team.business.model.User;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class SignUpValidator implements ConstraintValidator<SignUp, User> {

  @Override
  public void initialize(SignUp constraintAnnotation) {
  }

  @Override
  public boolean isValid(User value, ConstraintValidatorContext context) {
    return true;
  }
}
