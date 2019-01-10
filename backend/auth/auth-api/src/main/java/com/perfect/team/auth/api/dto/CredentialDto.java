package com.perfect.team.auth.api.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.perfect.team.auth.api.view.BaseView.Create;
import com.perfect.team.auth.api.view.BaseView.Read;
import com.perfect.team.auth.api.view.BaseView.SignIn;
import com.perfect.team.auth.api.view.BaseView.Update;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CredentialDto {

  @NotNull
  @JsonView({Read.class, Update.class})
  private Long id;
  @NotNull
  @JsonView({Create.class, Read.class, SignIn.class})
  private String username;
  @NotNull
  @JsonView({Create.class, Update.class, SignIn.class})
  private String password;
  @JsonView({Read.class})
  private Boolean confirmed;
  @NotNull
  @JsonView({Create.class, Read.class})
  private Long userId;
}
