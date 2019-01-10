package com.perfect.team.auth.api.event;

import com.perfect.team.auth.api.dto.CredentialDto;

public class CredentialCreatedEvent extends CredentialChangedEvent {

  public CredentialCreatedEvent(CredentialDto cur) {
    super(null, cur);
  }
}
