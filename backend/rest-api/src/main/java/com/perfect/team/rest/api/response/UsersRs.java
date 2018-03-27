package com.perfect.team.rest.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.UserReadDto;
import java.util.List;

public class UsersRs {

  @JsonProperty(value = "users")
  private List<UserReadDto> userReadDtos;

  public List<UserReadDto> getUserReadDtos() {
    return userReadDtos;
  }

  public void setUserReadDtos(List<UserReadDto> userReadDtos) {
    this.userReadDtos = userReadDtos;
  }
}
