package com.perfect.team.business.event;

import com.perfect.team.business.event.base.ChangedBaseEvent;
import com.perfect.team.business.model.Confirmation;

public class ConfirmationCreatedEvent extends ChangedBaseEvent<Confirmation> {

  public ConfirmationCreatedEvent(Object source, Confirmation cur) {
    super(source, null, cur);
  }
}
