package com.perfect.team.business.event;

import com.perfect.team.common.model.Transfer;

public class TransferCreatedEvent extends TransferChangedEvent {

  public TransferCreatedEvent(Object source, Transfer newObject) {
    super(source, null, newObject);
  }
}
