package com.perfect.team.auth.imp.security;

import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsernamePasswordAuthentication implements Authentication {

  private String username;

  private String password;

  private UserDetails principal;

  private boolean authenticated;

  public UsernamePasswordAuthentication(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public UsernamePasswordAuthentication(String username, String password, UserDetails principal) {
    this.username = username;
    this.password = password;
    this.principal = principal;
    authenticated = true;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return principal.getAuthorities();
  }

  @Override
  public Object getCredentials() {
    return password;
  }

  @Override
  public Object getDetails() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return principal == null ? username : principal;
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
    return null;
  }
}
