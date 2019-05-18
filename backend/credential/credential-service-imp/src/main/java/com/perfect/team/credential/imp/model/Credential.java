package com.perfect.team.credential.imp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credential {

  private Long id;
  private String username;
  private String password;
  private Boolean confirmed;
  private Long userId;
}
