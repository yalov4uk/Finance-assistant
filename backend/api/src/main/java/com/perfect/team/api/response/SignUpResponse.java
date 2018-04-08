package com.perfect.team.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.UserReadDto;

public class SignUpResponse {

  @JsonProperty(value = "user")
  private UserReadDto userDto;

  public UserReadDto getUserDto() {
    return userDto;
  }

  public void setUserDto(UserReadDto userDto) {
    this.userDto = userDto;
  }
}
