package com.perfect.team.business.event;

import com.perfect.team.common.model.Transaction;

public class TransactionDeletedEvent extends TransactionChangedEvent {

  public TransactionDeletedEvent(Object source, Transaction oldObject) {
    super(source, oldObject, null);
  }
}
