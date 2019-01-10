package com.perfect.team.business.event;

import com.perfect.team.common.model.Account;

public class AccountCreatedEvent extends AccountChangedEvent {

  public AccountCreatedEvent(Object source, Account newObject) {
    super(source, null, newObject);
  }
}
