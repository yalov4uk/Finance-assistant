package com.perfect.team.rest.impl.filter;

import com.perfect.team.business.security.TokenAuthentication;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class BearerAuthenticationFilter extends OncePerRequestFilter {

  private static final String AUTHORIZATION_HEADER = "Authorization";
  private static final String BEARER = "Bearer ";

  private AuthenticationManager authenticationManager;

  public BearerAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    String authHeader = request.getHeader(AUTHORIZATION_HEADER);
    if (authHeader == null || !authHeader.startsWith(BEARER)) {
      filterChain.doFilter(request, response);
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
    filterChain.doFilter(request, response);
  }
}
