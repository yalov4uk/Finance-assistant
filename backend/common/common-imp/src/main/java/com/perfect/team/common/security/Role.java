package com.perfect.team.common.security;

public enum Role {

  EMAIL, EMAIL_CONFIRMED, FACEBOOK;

  private static final String ROLE_PREFIX = "ROLE_";

  @Override
  public String toString() {
    return ROLE_PREFIX + this.name();
  }
}
