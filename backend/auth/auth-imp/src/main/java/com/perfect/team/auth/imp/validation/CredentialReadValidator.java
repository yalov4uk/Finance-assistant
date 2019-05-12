package com.perfect.team.auth.imp.validation;

import com.perfect.team.auth.imp.model.Credential;
import com.perfect.team.auth.imp.validation.constraint.CredentialId;
import com.perfect.team.auth.imp.validation.constraint.CredentialRead;
import com.perfect.team.legacy.client.validation.constraint.UserIdClient;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CredentialReadValidator implements ConstraintValidator<CredentialRead, Credential> {

  private final ConstraintValidator<CredentialId, Long> credentialIdValidator;
  private final ConstraintValidator<UserIdClient, Long> userIdValidator;

  @Override
  public void initialize(CredentialRead constraintAnnotation) {
  }

  @Override
  public boolean isValid(Credential value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (value.getId() != null && !credentialIdValidator.isValid(value.getId(), context)) {
      valid = false;
    }
    if (value.getUserId() != null && !userIdValidator.isValid(value.getUserId(), context)) {
      valid = false;
    }
    return valid;
  }
}
