package com.perfect.team.user.api.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.perfect.team.common.api.view.BaseView;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import lombok.Data;

@Data
public class UserDto {

  @Null(groups = BaseView.Create.class)
  @JsonView(BaseView.Read.class)
  private Long id;
  @NotNull(groups = BaseView.Create.class)
  @JsonView(BaseView.Read.class)
  private String name;
}
