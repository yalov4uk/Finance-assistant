package com.perfect.team.credential.imp.service;


import com.perfect.team.credential.imp.model.Credential;
import com.perfect.team.credential.imp.validation.constraint.CredentialCreate;
import com.perfect.team.credential.imp.validation.constraint.CredentialId;
import com.perfect.team.credential.imp.validation.constraint.CredentialRead;
import com.perfect.team.credential.imp.validation.constraint.CredentialUpdate;
import java.util.List;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CredentialService {

  Long create(@CredentialCreate Credential bean);

  List<Credential> read(@CredentialRead Credential bean);

  Credential update(@CredentialUpdate Credential bean);

  void delete(@CredentialId Long id);
}
