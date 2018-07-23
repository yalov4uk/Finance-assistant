package com.perfect.team.common.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.dto.UserReadDto;

public class UserResponse {

  @JsonProperty(value = "user")
  private UserReadDto userDto;

  public UserReadDto getUserDto() {
    return userDto;
  }

  public void setUserDto(UserReadDto userDto) {
    this.userDto = userDto;
  }
}
