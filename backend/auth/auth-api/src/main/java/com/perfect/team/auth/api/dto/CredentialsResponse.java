package com.perfect.team.auth.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CredentialsResponse {

  @NotNull
  @JsonProperty(value = "credentials")
  private List<@Valid CredentialDto> credentialDtos;
}
