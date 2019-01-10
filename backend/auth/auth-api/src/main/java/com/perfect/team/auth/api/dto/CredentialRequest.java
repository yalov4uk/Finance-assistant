package com.perfect.team.auth.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.perfect.team.auth.api.view.BaseView;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CredentialRequest {

  @JsonView(BaseView.All.class)
  @NotNull
  @Valid
  @JsonProperty("credential")
  private CredentialDto credentialDto;
}
