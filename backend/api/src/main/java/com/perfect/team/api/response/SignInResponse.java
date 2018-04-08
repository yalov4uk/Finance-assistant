package com.perfect.team.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.UserReadDto;

public class SignInResponse {

  @JsonProperty(value = "user")
  private UserReadDto userDto;

  @JsonProperty(value = "token")
  private String token;

  public UserReadDto getUserDto() {
    return userDto;
  }

  public void setUserDto(UserReadDto userDto) {
    this.userDto = userDto;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
