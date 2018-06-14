package com.perfect.team.business.event;

import com.perfect.team.business.model.Transaction;

public class TransactionCreatedEvent extends TransactionChangedEvent {

  public TransactionCreatedEvent(Object source, Transaction newObject) {
    super(source, null, newObject);
  }
}
