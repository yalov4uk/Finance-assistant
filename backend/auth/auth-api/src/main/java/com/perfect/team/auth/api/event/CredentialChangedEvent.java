package com.perfect.team.auth.api.event;


import com.perfect.team.auth.api.dto.CredentialDto;
import com.perfect.team.common.api.event.ChangedBaseEvent;

public class CredentialChangedEvent extends ChangedBaseEvent<CredentialDto> {

  public CredentialChangedEvent(CredentialDto old, CredentialDto cur) {
    super(old, cur);
  }
}
