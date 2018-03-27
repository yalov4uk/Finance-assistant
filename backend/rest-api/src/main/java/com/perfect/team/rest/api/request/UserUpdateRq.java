package com.perfect.team.rest.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.UserUpdateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class UserUpdateRq {

  @NotNull
  @Valid
  @JsonProperty(value = "user")
  private UserUpdateDto userUpdateDto;

  public UserUpdateDto getUserUpdateDto() {
    return userUpdateDto;
  }

  public void setUserUpdateDto(UserUpdateDto userUpdateDto) {
    this.userUpdateDto = userUpdateDto;
  }
}
