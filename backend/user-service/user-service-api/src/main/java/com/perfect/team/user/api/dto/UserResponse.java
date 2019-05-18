package com.perfect.team.user.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.perfect.team.common.api.view.BaseView;
import lombok.Data;

@Data
public class UserResponse {

  @JsonView(BaseView.All.class)
  @JsonProperty(value = "user")
  private UserDto userDto;
}
