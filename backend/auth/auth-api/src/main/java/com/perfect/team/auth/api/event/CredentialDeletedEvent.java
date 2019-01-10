package com.perfect.team.auth.api.event;


import com.perfect.team.auth.api.dto.CredentialDto;

public class CredentialDeletedEvent extends CredentialChangedEvent {

  public CredentialDeletedEvent(CredentialDto old) {
    super(old, null);
  }
}
