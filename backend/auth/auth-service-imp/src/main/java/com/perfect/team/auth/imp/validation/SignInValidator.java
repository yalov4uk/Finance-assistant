package com.perfect.team.auth.imp.validation;

import com.perfect.team.auth.imp.validation.constraint.SignIn;
import com.perfect.team.credential.api.dto.CredentialDto;
import com.perfect.team.credential.api.dto.CredentialsResponse;
import com.perfect.team.credential.client.CredentialClient;
import java.util.Collection;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
@Component
public class SignInValidator implements ConstraintValidator<SignIn, Object[]> {

  private final CredentialClient credentialClient;

  private final PasswordEncoder passwordEncoder;

  @Override
  public boolean isValid(Object[] value, ConstraintValidatorContext context) {
    String username = (String) value[0];
    String password = (String) value[1];
    ResponseEntity<CredentialsResponse> response = credentialClient
        .read(new CredentialDto(username));
    Collection<CredentialDto> credentials = response.getBody().getCredentialDtos();
    if (credentials.isEmpty() || credentials.stream()
        .noneMatch(c -> passwordEncoder.matches(password, c.getPassword()))) {
      return false;
    }
    return true;
  }
}
