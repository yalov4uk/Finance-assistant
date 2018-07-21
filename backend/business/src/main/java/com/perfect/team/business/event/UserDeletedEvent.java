package com.perfect.team.business.event;

import com.perfect.team.common.model.User;

public class UserDeletedEvent extends UserChangedEvent {

  public UserDeletedEvent(Object source, User oldObject) {
    super(source, oldObject, null);
  }
}
