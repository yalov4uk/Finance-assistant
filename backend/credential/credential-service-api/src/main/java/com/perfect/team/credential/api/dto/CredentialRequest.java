package com.perfect.team.credential.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.view.BaseView;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredentialRequest {

  @Valid
  @NotNull(groups = BaseView.All.class)
  @JsonProperty("credential")
  private CredentialDto credentialDto;
}
