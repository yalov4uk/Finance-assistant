package com.perfect.team.common.security;

import com.perfect.team.common.middleware.BearerAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;

@RequiredArgsConstructor
public class CommonWebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final JwtAuthenticationProvider jwtAuthenticationProvider;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.addFilterBefore(new BearerAuthenticationFilter(authenticationManagerBean()),
        RequestCacheAwareFilter.class)
        .csrf()
        .disable()
        .logout()
        .disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers(permitAll())
        .permitAll()
        .anyRequest()
        .authenticated();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(jwtAuthenticationProvider);
  }

  protected String[] permitAll() {
    return new String[]{
        "/*/swagger*"
    };
  }
}
