package com.perfect.team.common.security;

import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class TokenAuthentication implements Authentication {

  private String token;

  private UserDetails principal;

  private boolean authenticated;

  public TokenAuthentication(String token) {
    this.token = token;
  }

  public TokenAuthentication(String token, UserDetails principal) {
    this.token = token;
    this.principal = principal;
    authenticated = true;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return principal.getAuthorities();
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getDetails() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return principal == null ? token : principal;
  }

  @Override
  public boolean isAuthenticated() {
    return authenticated;
  }

  @Override
  public void setAuthenticated(boolean b) throws IllegalArgumentException {
    throw new IllegalArgumentException();
  }

  @Override
  public String getName() {
    return token;
  }
}
