package com.perfect.team.business.security;

import com.perfect.team.business.helper.JwtHelper;
import java.io.UnsupportedEncodingException;
import javax.inject.Inject;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

  @Inject
  private JwtHelper jwtHelper;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;
    if (tokenAuthentication.getToken() == null) {
      throw new AuthenticationCredentialsNotFoundException("Token is null");
    }
    try {
      UserDetails userDetails = jwtHelper.parse(tokenAuthentication.getToken());
      authentication = new TokenAuthentication(tokenAuthentication.getToken(), userDetails);
    } catch (UnsupportedEncodingException | AuthenticationException e) {
      throw new BadCredentialsException("Invalid token");
    }
    return authentication;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return TokenAuthentication.class.isAssignableFrom(authentication);
  }
}
