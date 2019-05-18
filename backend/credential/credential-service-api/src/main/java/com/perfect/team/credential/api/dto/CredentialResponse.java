package com.perfect.team.credential.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CredentialResponse {

  @JsonProperty(value = "credential")
  private CredentialDto credentialDto;
}
