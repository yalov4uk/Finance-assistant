package com.perfect.team.user.api.event;


import com.perfect.team.common.api.event.ChangedBaseEvent;
import com.perfect.team.user.api.dto.UserDto;

public class UserChangedEvent extends ChangedBaseEvent<UserDto> {

  public UserChangedEvent(UserDto oldObject, UserDto newObject) {
    super(oldObject, newObject);
  }
}
