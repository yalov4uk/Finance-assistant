package com.perfect.team.credential.api.event;

import com.perfect.team.credential.api.dto.CredentialDto;

public class CredentialCreatedEvent extends CredentialChangedEvent {

  public CredentialCreatedEvent(CredentialDto cur) {
    super(null, cur);
  }
}
