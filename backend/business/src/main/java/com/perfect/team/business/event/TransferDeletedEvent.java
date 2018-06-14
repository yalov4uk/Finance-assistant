package com.perfect.team.business.event;

import com.perfect.team.business.model.Transfer;

public class TransferDeletedEvent extends TransferChangedEvent {

  public TransferDeletedEvent(Object source, Transfer oldObject) {
    super(source, oldObject, null);
  }
}
