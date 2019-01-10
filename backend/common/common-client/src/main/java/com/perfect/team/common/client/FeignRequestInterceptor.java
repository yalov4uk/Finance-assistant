package com.perfect.team.common.client;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.context.SecurityContextHolder;

public class FeignRequestInterceptor implements RequestInterceptor {

  private static final String BEARER = "Bearer ";

  @Override
  public void apply(RequestTemplate template) {
    String token = SecurityContextHolder.getContext().getAuthentication().getName();
    template.header(AUTHORIZATION, BEARER + token);
  }
}
