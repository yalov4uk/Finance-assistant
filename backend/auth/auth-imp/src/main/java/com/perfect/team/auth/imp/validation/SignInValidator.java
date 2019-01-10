package com.perfect.team.auth.imp.validation;

import com.perfect.team.auth.imp.model.Credential;
import com.perfect.team.auth.imp.repository.CredentialMapper;
import com.perfect.team.auth.imp.validation.constraint.SignIn;
import java.util.Collection;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
@Component
public class SignInValidator implements ConstraintValidator<SignIn, Object[]> {

  private  final CredentialMapper credentialMapper;

  private  final PasswordEncoder passwordEncoder;

  @Override
  public void initialize(SignIn constraintAnnotation) {
  }

  @Override
  public boolean isValid(Object[] value, ConstraintValidatorContext context) {
    String username = (String) value[0];
    String password = (String) value[1];
    Collection<Credential> credentials = credentialMapper.select(null, username, null, null);
    if (credentials.isEmpty() || credentials.stream()
        .noneMatch(c -> passwordEncoder.matches(password, c.getPassword()))) {
      return false;
    }
    return true;
  }
}
