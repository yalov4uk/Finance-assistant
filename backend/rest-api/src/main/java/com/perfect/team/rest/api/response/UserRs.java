package com.perfect.team.rest.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.UserReadDto;

public class UserRs {

  @JsonProperty(value = "user")
  private UserReadDto userReadDto;

  public UserReadDto getUserReadDto() {
    return userReadDto;
  }

  public void setUserReadDto(UserReadDto userReadDto) {
    this.userReadDto = userReadDto;
  }
}
