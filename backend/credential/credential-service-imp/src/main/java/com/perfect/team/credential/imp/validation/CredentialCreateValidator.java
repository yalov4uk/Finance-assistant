package com.perfect.team.credential.imp.validation;

import com.perfect.team.credential.imp.model.Credential;
import com.perfect.team.credential.imp.repository.CredentialMapper;
import com.perfect.team.credential.imp.validation.constraint.CredentialCreate;
import com.perfect.team.user.client.validation.constraint.UserIdClient;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CredentialCreateValidator implements
    ConstraintValidator<CredentialCreate, Credential> {

  private final CredentialMapper credentialMapper;
  private final ConstraintValidator<UserIdClient, Long> userIdClientValidator;

  @Override
  public boolean isValid(Credential value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (!userIdClientValidator.isValid(value.getUserId(), context)) {
      valid = false;
    }
    if (!credentialMapper.select(null, value.getUsername(), true, null).isEmpty()) {
      valid = false;
      context.buildConstraintViolationWithTemplate("Username already in use")
          .addConstraintViolation();
    }
    return valid;
  }
}
