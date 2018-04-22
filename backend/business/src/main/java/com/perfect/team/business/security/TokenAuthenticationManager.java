package com.perfect.team.business.security;

import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.model.User;
import com.perfect.team.business.service.TokenService;
import javax.inject.Inject;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class TokenAuthenticationManager implements AuthenticationManager {

  @Inject
  private TokenService tokenService;

  @Inject
  private UserMapper userMapper;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    if (authentication instanceof TokenAuthentication) {
      return grantTokenAuthentication((TokenAuthentication) authentication);
    }
    throw new AuthenticationServiceException("Wrong Authentication class");
  }

  private Authentication grantTokenAuthentication(TokenAuthentication authentication)
      throws AuthenticationCredentialsNotFoundException {
    if (authentication.getToken() == null) {
      throw new AuthenticationCredentialsNotFoundException("Token is null");
    }
    Long userId = tokenService.decode(authentication.getToken());
    User user = userMapper.selectById(userId);
    UserDetails userDetails = new CustomUserDetails(user);
    authentication = new TokenAuthentication(authentication.getToken(), userDetails);
    authentication.setAuthenticated(true);
    return authentication;
  }
}
