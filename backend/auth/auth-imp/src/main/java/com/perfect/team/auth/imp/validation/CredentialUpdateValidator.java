package com.perfect.team.auth.imp.validation;

import com.perfect.team.auth.imp.model.Credential;
import com.perfect.team.auth.imp.repository.CredentialMapper;
import com.perfect.team.auth.imp.validation.constraint.CredentialId;
import com.perfect.team.auth.imp.validation.constraint.CredentialUpdate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CredentialUpdateValidator implements
    ConstraintValidator<CredentialUpdate, Credential> {

  private final CredentialMapper credentialMapper;
  private final ConstraintValidator<CredentialId, Long> credentialIdValidator;

  @Override
  public void initialize(CredentialUpdate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Credential value, ConstraintValidatorContext context) {
    boolean valid = true;
    if (!credentialIdValidator.isValid(value.getId(), context)) {
      valid = false;
    }
    Credential credential = credentialMapper.selectById(value.getId());
    if (!credentialMapper
        .select(null, value.getUsername() == null ? credential.getUsername() : value.getUsername(),
            true, null).isEmpty()) {
      valid = false;
      context.buildConstraintViolationWithTemplate("Username already in use")
          .addConstraintViolation();
    }
    return valid;
  }
}
