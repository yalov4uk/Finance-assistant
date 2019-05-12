package com.perfect.team.user.api.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.perfect.team.common.api.view.BaseView;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  @Null(groups = BaseView.Create.class)
  @JsonView(BaseView.Read.class)
  private Long id;
  @NotNull(groups = BaseView.Create.class)
  @JsonView(BaseView.Read.class)
  private String name;

  public UserDto(Long id) {
    this.id = id;
  }
}
