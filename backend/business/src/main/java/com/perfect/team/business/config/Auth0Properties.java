package com.perfect.team.business.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:config/business.properties")
@Configuration
@Component
public class Auth0Properties {

  @Value("${auth0.secret}")
  public String secret;

  @Value("${auth0.issuer}")
  public String issuer;
}
