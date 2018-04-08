package com.perfect.team.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.UserReadDto;
import java.util.List;

public class UsersResponse {

  @JsonProperty(value = "users")
  private List<UserReadDto> userDtos;

  public List<UserReadDto> getUserDtos() {
    return userDtos;
  }

  public void setUserDtos(List<UserReadDto> userDtos) {
    this.userDtos = userDtos;
  }
}
