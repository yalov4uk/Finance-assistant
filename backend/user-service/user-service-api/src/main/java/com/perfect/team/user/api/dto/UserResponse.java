package com.perfect.team.user.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserResponse {

  @JsonProperty(value = "user")
  private UserDto userDto;
}
