package com.perfect.team.user.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class UsersResponse {

  @JsonProperty(value = "users")
  private List<UserDto> userDtos;
}
