package com.perfect.team.rest.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.UserReadDto;

public class AuthRs {

  @JsonProperty(value = "user")
  private UserReadDto userReadDto;

  @JsonProperty(value = "token")
  private String token;

  public UserReadDto getUserReadDto() {
    return userReadDto;
  }

  public void setUserReadDto(UserReadDto userReadDto) {
    this.userReadDto = userReadDto;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
