package com.perfect.team.business.validation;

import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.common.model.User;
import com.perfect.team.business.validation.constraint.SignIn;
import java.util.List;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
@Component
public class SignInValidator implements ConstraintValidator<SignIn, Object[]> {

  @Inject
  private UserMapper userMapper;

  @Inject
  private PasswordEncoder passwordEncoder;

  @Override
  public void initialize(SignIn constraintAnnotation) {
  }

  @Override
  public boolean isValid(Object[] value, ConstraintValidatorContext context) {
    String email = (String) value[0], password = (String) value[1];
    List<User> users = userMapper.select(null, null, email);
    if (users.isEmpty() || !passwordEncoder.matches(password, users.get(0).getPassword())) {
      return false;
    }
    return true;
  }
}
