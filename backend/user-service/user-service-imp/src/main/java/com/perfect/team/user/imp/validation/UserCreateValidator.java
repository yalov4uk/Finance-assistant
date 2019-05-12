package com.perfect.team.user.imp.validation;


import com.perfect.team.user.imp.model.User;
import com.perfect.team.user.imp.validation.constraint.UserCreate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreateValidator implements ConstraintValidator<UserCreate, User> {

  @Override
  public boolean isValid(User value, ConstraintValidatorContext context) {
    return true;
  }
}
