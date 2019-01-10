package com.perfect.team.business.event;

import com.perfect.team.common.model.Transaction;

public class TransactionChangedEvent extends
    com.perfect.team.business.event.base.ChangedBaseEvent<Transaction> {

  public TransactionChangedEvent(Object source, Transaction oldObject, Transaction newObject) {
    super(source, oldObject, newObject);
  }
}
