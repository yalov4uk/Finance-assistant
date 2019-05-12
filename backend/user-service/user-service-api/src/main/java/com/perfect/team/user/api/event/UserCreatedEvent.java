package com.perfect.team.user.api.event;

import com.perfect.team.user.api.dto.UserDto;

public class UserCreatedEvent extends UserChangedEvent {

  public UserCreatedEvent(UserDto newObject) {
    super(null, newObject);
  }
}
