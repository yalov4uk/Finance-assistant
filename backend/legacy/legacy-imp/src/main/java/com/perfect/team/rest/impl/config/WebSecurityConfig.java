package com.perfect.team.rest.impl.config;

import com.perfect.team.common.security.Role;
import com.perfect.team.common.middleware.BearerAuthenticationFilter;
import com.perfect.team.common.security.JwtAuthenticationProvider;
import javax.inject.Inject;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Inject
  private JwtAuthenticationProvider jwtAuthenticationProvider;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers(String.format("/%s/swagger*", RestImplConfig.SERVLET_PATH))
        .permitAll()
        .antMatchers(String.format("/%s/confirmations", RestImplConfig.SERVLET_PATH),
            String.format("/%s/confirmations/*", RestImplConfig.SERVLET_PATH))
        .permitAll()
        .antMatchers(String.format("/%s/**", RestImplConfig.SERVLET_PATH))
        .hasRole(Role.EMAIL_CONFIRMED.name())
        .anyRequest()
        .authenticated()
        .and()
        .addFilterBefore(
            new BearerAuthenticationFilter(authenticationManagerBean()),
            RequestCacheAwareFilter.class)
        .csrf().disable()
        .logout().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .authenticationProvider(jwtAuthenticationProvider);
  }
}
