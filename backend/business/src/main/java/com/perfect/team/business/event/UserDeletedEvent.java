package com.perfect.team.business.event;

import com.perfect.team.business.model.User;

public class UserDeletedEvent extends UserChangedEvent {

  public UserDeletedEvent(Object source, User oldObject) {
    super(source, oldObject, null);
  }
}
