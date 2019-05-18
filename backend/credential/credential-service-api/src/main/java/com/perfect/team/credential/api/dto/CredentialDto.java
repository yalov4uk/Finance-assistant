package com.perfect.team.credential.api.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.perfect.team.common.api.view.BaseView.Create;
import com.perfect.team.common.api.view.BaseView.Read;
import com.perfect.team.common.api.view.BaseView.Update;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredentialDto {

  @Null(groups = Create.class)
  @JsonView({Read.class, Update.class})
  private Long id;
  @NotNull(groups = Create.class)
  @JsonView(Read.class)
  private String username;
  @NotNull(groups = Create.class)
  @JsonView(Update.class)
  private String password;
  @Null(groups = Create.class)
  @JsonView(Read.class)
  private Boolean confirmed;
  @NotNull(groups = {Create.class, Update.class})
  @JsonView(Read.class)
  private Long userId;

  public CredentialDto(String username) {
    this.username = username;
  }
}
