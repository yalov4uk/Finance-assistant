package com.perfect.team.business.event;

import com.perfect.team.business.model.User;

public class UserCreatedEvent extends UserChangedEvent {

  public UserCreatedEvent(Object source, User newObject) {
    super(source, null, newObject);
  }
}
