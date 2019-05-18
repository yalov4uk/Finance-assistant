package com.perfect.team.credential.imp.config;

import com.perfect.team.common.security.CommonWebSecurityConfig;
import com.perfect.team.common.security.TokenAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class WebSecurityConfig extends CommonWebSecurityConfig {

  public WebSecurityConfig(TokenAuthenticationProvider tokenAuthenticationProvider) {
    super(tokenAuthenticationProvider);
  }
}
