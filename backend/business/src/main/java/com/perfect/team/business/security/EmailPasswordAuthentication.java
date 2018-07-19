package com.perfect.team.business.security;

import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class EmailPasswordAuthentication implements Authentication {

  private String email;

  private String password;

  private UserDetails principal;

  private boolean authenticated;

  public EmailPasswordAuthentication(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public EmailPasswordAuthentication(String email, String password, UserDetails principal) {
    this.email = email;
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
    return principal;
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
    return principal.getUsername();
  }

  public String getEmail() {
    return email;
  }
}
