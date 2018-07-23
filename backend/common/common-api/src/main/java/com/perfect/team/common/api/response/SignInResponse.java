package com.perfect.team.common.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignInResponse {

  @JsonProperty(value = "token")
  private String token;

  public SignInResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
