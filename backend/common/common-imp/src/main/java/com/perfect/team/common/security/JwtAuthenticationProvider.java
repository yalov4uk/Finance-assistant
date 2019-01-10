package com.perfect.team.common.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

  private final ObjectMapper objectMapper;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    if (authentication.getPrincipal() == null) {
      throw new AuthenticationCredentialsNotFoundException("Token is null");
    }
    String token = (String) authentication.getPrincipal();
    UserDetails userDetails;
    try {
      userDetails = objectMapper.readValue(token, UserContext.class);
    } catch (IOException e) {
      throw new RuntimeException("Cannot parse token");
    }
    authentication = new TokenAuthentication(token, userDetails);
    return authentication;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return TokenAuthentication.class.isAssignableFrom(authentication);
  }
}
