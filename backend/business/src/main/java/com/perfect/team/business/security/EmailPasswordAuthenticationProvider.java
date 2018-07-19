package com.perfect.team.business.security;

import com.perfect.team.business.config.Roles;
import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.model.User;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.inject.Inject;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EmailPasswordAuthenticationProvider implements AuthenticationProvider {

  @Inject
  private UserMapper userMapper;

  @Inject
  private PasswordEncoder passwordEncoder;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    EmailPasswordAuthentication emailPasswordAuthentication = (EmailPasswordAuthentication) authentication;
    String email = emailPasswordAuthentication.getEmail();
    String password = (String) emailPasswordAuthentication.getCredentials();
    if (email == null || password == null) {
      throw new AuthenticationCredentialsNotFoundException("Email or password is null");
    }
    UserDetails userDetails = retrive(email);
    if (!passwordEncoder.matches(password, userDetails.getPassword())) {
      throw new BadCredentialsException("Wrong password");
    }
    authentication = new EmailPasswordAuthentication(email, password, userDetails);
    return authentication;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return EmailPasswordAuthentication.class.isAssignableFrom(authentication);
  }

  private UserDetails retrive(String email) {
    Collection<User> existingUsers = userMapper.select(null, null, email);
    if (existingUsers.isEmpty()) {
      throw new UsernameNotFoundException("User not found");
    }
//    todo: consider user's email uniqueness
    User existingUser = ((List<User>) existingUsers).get(0);
    Collection<String> roles = new HashSet<>();
    if (existingUser.getConfirmed()) {
      roles.add(Roles.CONFIRMED);
    } else {
      roles.add(Roles.NOT_CONFIRMED);
    }
    return new CustomUserDetails(existingUser, roles);
  }
}
