package com.perfect.team.business.event;

import com.perfect.team.business.event.base.ChangedBaseEvent;
import com.perfect.team.common.model.Transfer;

public class TransferChangedEvent extends ChangedBaseEvent<Transfer> {

  public TransferChangedEvent(Object source, Transfer oldObject, Transfer newObject) {
    super(source, oldObject, newObject);
  }
}
