package com.perfect.team.rest.impl.config;

import com.perfect.team.business.config.Roles;
import com.perfect.team.rest.impl.filter.BearerAuthenticationFilter;
import javax.inject.Inject;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Inject
  private AuthenticationManager authenticationManager;

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/api/v1/swagger*");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().addFilterBefore(new BearerAuthenticationFilter(authenticationManager),
        RequestCacheAwareFilter.class)
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/api/v1/users").permitAll()
        .antMatchers("/api/v1/auth/*").permitAll()
        .antMatchers("/api/v1/confirmations").hasRole(Roles.NOT_CONFIRMED)
        .antMatchers("/api/v1/**").hasRole(Roles.CONFIRMED)
        .anyRequest().permitAll();
  }
}
