package com.perfect.team.user.api.event;

import com.perfect.team.user.api.dto.UserDto;

public class UserDeletedEvent extends UserChangedEvent {

  public UserDeletedEvent(UserDto oldObject) {
    super(oldObject, null);
  }
}
