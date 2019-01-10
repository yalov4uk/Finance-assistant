package com.perfect.team.auth.imp.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class Credential implements Serializable {

  private Long id;
  private String username;
  private String password;
  private Boolean confirmed;
  private Long userId;
}
