package com.perfect.team.auth.imp.service;

import com.perfect.team.auth.imp.model.Credential;
import com.perfect.team.auth.imp.validation.constraint.CredentialCreate;
import com.perfect.team.auth.imp.validation.constraint.CredentialId;
import com.perfect.team.auth.imp.validation.constraint.CredentialRead;
import com.perfect.team.auth.imp.validation.constraint.CredentialUpdate;
import com.perfect.team.legacy.client.validation.constraint.UserIdClient;
import java.util.List;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CredentialService {

  Long create(@CredentialCreate Credential bean);

  List<Credential> read(@CredentialRead Credential bean);

  Credential update(@CredentialUpdate Credential bean);

  void delete(@CredentialId Long id);
}
