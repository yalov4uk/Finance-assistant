package com.perfect.team.auth.api.dto;

import lombok.Data;

@Data
public class CredentialReadRequest {

  private Long id;
  private String username;
  private Boolean confirmed;
  private Long userId;
}
