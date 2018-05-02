package com.perfect.team.business.event;

import com.perfect.team.business.event.base.ChangedBaseEvent;
import com.perfect.team.business.model.Confirmation;

public class ConfirmationChangedEvent extends ChangedBaseEvent<Confirmation> {

  public ConfirmationChangedEvent(Object source, Confirmation old, Confirmation cur) {
    super(source, old, cur);
  }
}
