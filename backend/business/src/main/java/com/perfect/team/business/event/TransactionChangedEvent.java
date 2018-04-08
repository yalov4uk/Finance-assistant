package com.perfect.team.business.event;

import com.perfect.team.business.event.base.ChangedBaseEvent;
import com.perfect.team.business.model.Transaction;

public class TransactionChangedEvent extends ChangedBaseEvent<Transaction> {

  public TransactionChangedEvent(Object source, Transaction oldObject,
      Transaction newObject) {
    super(source, oldObject, newObject);
  }
}
