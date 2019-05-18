package com.perfect.team.credential.api.event;


import com.perfect.team.credential.api.dto.CredentialDto;

public class CredentialDeletedEvent extends CredentialChangedEvent {

  public CredentialDeletedEvent(CredentialDto old) {
    super(old, null);
  }
}
