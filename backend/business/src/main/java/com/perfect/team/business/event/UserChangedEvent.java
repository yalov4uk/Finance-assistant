package com.perfect.team.business.event;

import com.perfect.team.business.event.base.ChangedBaseEvent;
import com.perfect.team.business.model.User;

public class UserChangedEvent extends ChangedBaseEvent<User> {

  public UserChangedEvent(Object source, User oldObject,
      User newObject) {
    super(source, oldObject, newObject);
  }
}
