package com.perfect.team.business.security;

import com.perfect.team.business.config.Roles;
import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.model.User;
import com.perfect.team.business.service.CipherService;
import java.util.Collection;
import java.util.HashSet;
import javax.inject.Inject;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class TokenAuthenticationManager implements AuthenticationManager {

  @Inject
  private CipherService cipherService;

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
      throws AuthenticationException {
    if (authentication.getToken() == null) {
      throw new AuthenticationCredentialsNotFoundException("Confirmation is null");
    }
    Long userId = Long.parseLong((String) cipherService.decode(authentication.getToken()));
    User user = userMapper.selectById(userId);
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }
    UserDetails userDetails;
    Collection<GrantedAuthority> authorities = new HashSet<>();
    if (user.getConfirmed()) {
      authorities.add(new SimpleGrantedAuthority("ROLE_" + Roles.CONFIRMED));
      userDetails = new CustomUserDetails(user, authorities);
    } else {
      authorities.add(new SimpleGrantedAuthority("ROLE_" + Roles.NOT_CONFIRMED));
      userDetails = new CustomUserDetails(user, authorities);
    }
    authentication = new TokenAuthentication(authentication.getToken(), userDetails);
    authentication.setAuthenticated(true);
    return authentication;
  }
}
