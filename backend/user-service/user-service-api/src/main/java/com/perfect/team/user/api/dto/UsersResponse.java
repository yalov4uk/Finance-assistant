package com.perfect.team.user.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.perfect.team.common.api.view.BaseView;
import java.util.List;
import lombok.Data;

@Data
public class UsersResponse {

  @JsonView(BaseView.All.class)
  @JsonProperty(value = "users")
  private List<UserDto> userDtos;
}
