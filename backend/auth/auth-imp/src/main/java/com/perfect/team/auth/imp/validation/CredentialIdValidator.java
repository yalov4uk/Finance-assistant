package com.perfect.team.auth.imp.validation;

import com.perfect.team.auth.imp.model.Credential;
import com.perfect.team.auth.imp.repository.CredentialMapper;
import com.perfect.team.auth.imp.validation.constraint.CredentialId;
import com.perfect.team.legacy.client.validation.constraint.UserIdClient;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CredentialIdValidator implements ConstraintValidator<CredentialId, Long> {

  private final CredentialMapper credentialMapper;
  private final ConstraintValidator<UserIdClient, Long> userIdValidator;

  @Override
  public void initialize(CredentialId constraintAnnotation) {
  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    boolean valid = true;
    Credential credential = credentialMapper.selectById(value);
    if (credential == null) {
      valid = false;
      context.buildConstraintViolationWithTemplate("Credential not found").addConstraintViolation();
    } else if (!userIdValidator.isValid(credential.getUserId(), context)) {
      valid = false;
    }
    return valid;
  }
}
