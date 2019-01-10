package com.perfect.team.auth.imp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("jwt")
@Component
public class JwtProperties {

  public String secret;

  public String issuer;
}
