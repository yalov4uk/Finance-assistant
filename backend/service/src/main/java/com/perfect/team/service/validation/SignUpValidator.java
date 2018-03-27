package com.perfect.team.service.validation;

import com.perfect.team.service.request.SignUpRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class SignUpValidator implements ConstraintValidator<SignUp, SignUpRequest> {

  @Override
  public void initialize(SignUp constraintAnnotation) {
  }

  @Override
  public boolean isValid(SignUpRequest value, ConstraintValidatorContext context) {
    return true;
  }
}
