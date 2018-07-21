package com.perfect.team.business.event;

import com.perfect.team.common.model.Account;

public class AccountDeletedEvent extends AccountChangedEvent {

  public AccountDeletedEvent(Object source, Account oldObject) {
    super(source, oldObject, null);
  }
}
