package com.perfect.team.business.event;

import com.perfect.team.common.model.Confirmation;

public class ConfirmationCreatedEvent extends
    com.perfect.team.business.event.base.ChangedBaseEvent<Confirmation> {

  public ConfirmationCreatedEvent(Object source, Confirmation cur) {
    super(source, null, cur);
  }
}
