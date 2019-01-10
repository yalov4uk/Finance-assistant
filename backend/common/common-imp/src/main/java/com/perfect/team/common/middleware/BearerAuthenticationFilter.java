package com.perfect.team.common.middleware;


import com.perfect.team.common.security.TokenAuthentication;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

@RequiredArgsConstructor
public class BearerAuthenticationFilter extends GenericFilterBean {

  private static final String BEARER = "Bearer ";

  private final AuthenticationManager authenticationManager;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    String authHeader = ((HttpServletRequest) request).getHeader(HttpHeaders.AUTHORIZATION);
    if (authHeader == null || !authHeader.startsWith(BEARER) || !authenticationIsRequired()) {
      chain.doFilter(request, response);
      return;
    }
    try {
      String token = authHeader.substring(BEARER.length(), authHeader.length());
      Authentication authRequest = new TokenAuthentication(token);
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
}
