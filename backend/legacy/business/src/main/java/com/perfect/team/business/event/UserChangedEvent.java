package com.perfect.team.business.event;

import com.perfect.team.common.model.User;

public class UserChangedEvent extends com.perfect.team.business.event.base.ChangedBaseEvent<User> {

  public UserChangedEvent(Object source, User oldObject, User newObject) {
    super(source, oldObject, newObject);
  }
}
