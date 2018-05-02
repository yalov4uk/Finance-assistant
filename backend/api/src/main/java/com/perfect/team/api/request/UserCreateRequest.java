package com.perfect.team.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.UserCreateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class UserCreateRequest {

  @NotNull
  @Valid
  @JsonProperty(value = "user")
  private UserCreateDto userCreateDto;

  public UserCreateDto getUserCreateDto() {
    return userCreateDto;
  }

  public void setUserCreateDto(UserCreateDto userCreateDto) {
    this.userCreateDto = userCreateDto;
  }
}
