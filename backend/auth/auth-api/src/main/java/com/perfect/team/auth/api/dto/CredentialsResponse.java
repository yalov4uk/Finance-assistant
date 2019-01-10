package com.perfect.team.auth.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class CredentialsResponse {

  @JsonProperty(value = "credentials")
  private List<CredentialDto> credentialDtos;
}
