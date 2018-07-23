package com.perfect.team.common.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.dto.UserUpdateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class UserUpdateRequest {

  @NotNull
  @Valid
  @JsonProperty(value = "user")
  private UserUpdateDto userDto;

  public UserUpdateDto getUserDto() {
    return userDto;
  }

  public void setUserDto(UserUpdateDto userDto) {
    this.userDto = userDto;
  }
}
