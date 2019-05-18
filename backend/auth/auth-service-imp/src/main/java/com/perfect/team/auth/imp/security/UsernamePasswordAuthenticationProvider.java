package com.perfect.team.auth.imp.security;

import com.perfect.team.common.security.Role;
import com.perfect.team.common.security.UserContext;
import com.perfect.team.credential.api.dto.CredentialDto;
import com.perfect.team.credential.api.dto.CredentialsResponse;
import com.perfect.team.credential.client.CredentialClient;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

  private final CredentialClient credentialClient;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = (String) authentication.getPrincipal();
    String password = (String) authentication.getCredentials();
    ResponseEntity<CredentialsResponse> response = credentialClient
        .read(new CredentialDto(username));
    Collection<CredentialDto> credentials = response.getBody().getCredentialDtos()
        .stream()
        .filter(c -> passwordEncoder.matches(password, c.getPassword()))
        .collect(Collectors.toSet());
    if (credentials.isEmpty()) {
      throw new BadCredentialsException("Wrong username or password");
    }
    Collection<String> roles = credentials.stream()
        .flatMap(c -> grantAuthorities(c).stream())
        .collect(Collectors.toSet());
    UserDetails userDetails = new UserContext(credentials.iterator().next().getUserId(), roles);
    authentication = new UsernamePasswordAuthentication(username, password, userDetails);
    return authentication;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return UsernamePasswordAuthentication.class.isAssignableFrom(authentication);
  }

  private Collection<String> grantAuthorities(CredentialDto credentialDto) {
    Collection<String> roles = new LinkedHashSet<>();
    roles.add(Role.NOT_CONFIRMED);
    if (credentialDto.getConfirmed()) {
      roles.add(Role.CONFIRMED);
    }
    return roles;
  }
}
