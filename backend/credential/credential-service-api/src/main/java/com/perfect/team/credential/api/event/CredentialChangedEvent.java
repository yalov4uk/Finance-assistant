package com.perfect.team.credential.api.event;


import com.perfect.team.common.api.event.ChangedBaseEvent;
import com.perfect.team.credential.api.dto.CredentialDto;

public class CredentialChangedEvent extends ChangedBaseEvent<CredentialDto> {

  public CredentialChangedEvent(CredentialDto old, CredentialDto cur) {
    super(old, cur);
  }
}
