package com.perfect.team.user.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.view.BaseView;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequest {

  @NotNull(groups = BaseView.All.class)
  @Valid
  @JsonProperty(value = "user")
  private UserDto userDto;
}
