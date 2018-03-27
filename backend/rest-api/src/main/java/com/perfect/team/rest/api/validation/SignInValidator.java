package com.perfect.team.rest.api.validation;

import com.perfect.team.rest.api.request.SignInRq;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SignInValidator implements ConstraintValidator<SignIn, SignInRq> {

  @Override
  public void initialize(SignIn constraintAnnotation) {
  }

  @Override
  public boolean isValid(SignInRq value, ConstraintValidatorContext context) {
    return value.getEmail() != null && value.getPassword() != null || value.getToken() != null;
  }
}
