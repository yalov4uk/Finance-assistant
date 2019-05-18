package com.perfect.team.auth.imp.config;

import static com.perfect.team.common.security.Role.NOT_CONFIRMED;

import com.perfect.team.auth.imp.middleware.UsernamePasswordAuthenticationFilter;
import com.perfect.team.auth.imp.security.UsernamePasswordAuthenticationProvider;
import com.perfect.team.common.security.CommonWebSecurityConfig;
import com.perfect.team.common.security.TokenAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;

@EnableWebSecurity
public class WebSecurityConfig extends CommonWebSecurityConfig {

  private final UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;

  public WebSecurityConfig(TokenAuthenticationProvider tokenAuthenticationProvider,
      UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider) {
    super(tokenAuthenticationProvider);
    this.usernamePasswordAuthenticationProvider = usernamePasswordAuthenticationProvider;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.addFilterBefore(new UsernamePasswordAuthenticationFilter(authenticationManagerBean()),
        RequestCacheAwareFilter.class)
        .authorizeRequests()
        .antMatchers("/tokens")
        .anonymous()
        .antMatchers("/signIn")
        .hasRole(NOT_CONFIRMED);
    super.configure(http);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(usernamePasswordAuthenticationProvider);
    super.configure(auth);
  }
}
