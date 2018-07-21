package com.perfect.team.rest.impl.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfect.team.api.dto.SignInDto;
import com.perfect.team.api.request.SignInRequest;
import com.perfect.team.business.security.EmailPasswordAuthentication;
import com.perfect.team.rest.impl.config.RestImplConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.glassfish.jersey.message.internal.ReaderWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class EmailPasswordAuthenticationFilter extends GenericFilterBean {

  private static final Logger logger = LoggerFactory
      .getLogger(EmailPasswordAuthenticationFilter.class);
  private static final ObjectMapper mapper = new ObjectMapper();

  private static final String SIGN_IN_PATH = String
      .format("/%s/auth/signIn", RestImplConfig.SERVLET_PATH);

  private final AuthenticationManager authenticationManager;

  public EmailPasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
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
      SignInDto signInDto = parseBody(request);
      String email = Optional.ofNullable(signInDto).map(SignInDto::getEmail).orElse(null);
      String password = Optional.ofNullable(signInDto).map(SignInDto::getPassword).orElse(null);
      Authentication authRequest = new EmailPasswordAuthentication(email, password);
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

  private SignInDto parseBody(ServletRequest request) {
    SignInDto signInDto = null;
    try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
      ReaderWriter.writeTo(request.getInputStream(), output);
      byte[] body = output.toByteArray();
      signInDto = mapper.readValue(body, SignInRequest.class).getSignInDto();
    } catch (IOException e) {
      logger.error("Error while parse json sign in request", e);
    }
    return signInDto;
  }
}
