package com.perfect.team.auth.imp.middleware;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfect.team.auth.imp.security.UsernamePasswordAuthentication;
import com.perfect.team.credential.api.dto.CredentialDto;
import com.perfect.team.credential.api.dto.CredentialRequest;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.GenericFilterBean;

@Slf4j
public class UsernamePasswordAuthenticationFilter extends GenericFilterBean {

  private static final ObjectMapper mapper = new ObjectMapper();

  private static final String SIGN_IN_PATH = "/signIn";

  private final AuthenticationManager authenticationManager;

  public UsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    if (!SIGN_IN_PATH.equals(httpRequest.getRequestURI()) ||
        !HttpMethod.POST.matches(httpRequest.getMethod()) || !authenticationIsRequired()) {
      chain.doFilter(request, response);
      return;
    }
    try {
      CredentialDto credentialDto = parseBody(request);
      String username = Optional.ofNullable(credentialDto.getUsername()).orElse("");
      String password = Optional.ofNullable(credentialDto.getPassword()).orElse("");
      Authentication authRequest = new UsernamePasswordAuthentication(username, password);
      Authentication authResult = authenticationManager.authenticate(authRequest);
      SecurityContextHolder.getContext().setAuthentication(authResult);
    } catch (AuthenticationException failed) {
      SecurityContextHolder.clearContext();
    }
    chain.doFilter(request, response);
  }

  private boolean authenticationIsRequired() {
    Authentication existingAuth = SecurityContextHolder.getContext().getAuthentication();
    return existingAuth == null || !existingAuth.isAuthenticated();
  }

  private CredentialDto parseBody(ServletRequest request) throws IOException {
    byte[] body = StreamUtils.copyToByteArray(request.getInputStream());
    return mapper.readValue(body, CredentialRequest.class).getCredentialDto();
  }
}
