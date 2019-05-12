package com.perfect.team.auth.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.perfect.team.auth.api.view.BaseView;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredentialRequest {

  @Valid
  @NotNull(groups = BaseView.All.class)
  @JsonProperty("credential")
  private CredentialDto credentialDto;
}
