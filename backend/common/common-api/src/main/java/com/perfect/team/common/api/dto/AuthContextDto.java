package com.perfect.team.common.api.dto;

import java.util.Collection;

public class AuthContextDto {

  private Long userId;

  private Collection<Role> roles;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Collection<Role> getRoles() {
    return roles;
  }

  public void setRoles(Collection<Role> roles) {
    this.roles = roles;
  }

  public enum Role {
    EMAIL_CONFIRMED, FACEBOOK
  }
}
