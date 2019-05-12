package com.perfect.team.user.imp.config;

import com.perfect.team.common.security.CommonWebSecurityConfig;
import com.perfect.team.common.security.TokenAuthenticationProvider;
import com.perfect.team.user.api.controller.UserController;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class WebSecurityConfig extends CommonWebSecurityConfig {

  public WebSecurityConfig(TokenAuthenticationProvider tokenAuthenticationProvider) {
    super(tokenAuthenticationProvider);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers(HttpMethod.POST, UserController.USERS)
        .permitAll();
    super.configure(http);
  }
}
