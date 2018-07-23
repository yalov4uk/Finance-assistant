package com.perfect.team.common.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.dto.AuthContextDto;

public class AuthContextResponse {

  @JsonProperty(value = "authContext")
  private AuthContextDto authContextDto;

  public AuthContextResponse() {
  }

  public AuthContextResponse(AuthContextDto authContextDto) {
    this.authContextDto = authContextDto;
  }

  public AuthContextDto getAuthContextDto() {
    return authContextDto;
  }

  public void setAuthContextDto(AuthContextDto authContextDto) {
    this.authContextDto = authContextDto;
  }
}
