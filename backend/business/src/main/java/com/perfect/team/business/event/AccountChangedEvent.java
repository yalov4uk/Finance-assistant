package com.perfect.team.business.event;

import com.perfect.team.business.event.base.ChangedBaseEvent;
import com.perfect.team.business.model.Account;

public class AccountChangedEvent extends ChangedBaseEvent<Account> {

  public AccountChangedEvent(Object source, Account oldObject,
      Account newObject) {
    super(source, oldObject, newObject);
  }
}
