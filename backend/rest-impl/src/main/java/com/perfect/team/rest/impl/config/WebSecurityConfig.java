package com.perfect.team.rest.impl.config;

import com.perfect.team.business.config.Roles;
import com.perfect.team.business.security.EmailPasswordAuthenticationProvider;
import com.perfect.team.business.security.JwtAuthenticationProvider;
import com.perfect.team.rest.impl.filter.BearerAuthenticationFilter;
import com.perfect.team.rest.impl.filter.EmailPasswordAuthenticationFilter;
import javax.inject.Inject;
import org.springframework.http.HttpMethod;
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

  @Inject
  private EmailPasswordAuthenticationProvider emailPasswordAuthenticationProvider;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers(String.format("/%s/swagger*", RestImplConfig.SERVLET_PATH))
        .permitAll()
        .antMatchers(HttpMethod.POST, String.format("/%s/users", RestImplConfig.SERVLET_PATH))
        .permitAll()
        .antMatchers(String.format("/%s/auth/*", RestImplConfig.SERVLET_PATH))
        .permitAll()
        .antMatchers(String.format("/%s/confirmations", RestImplConfig.SERVLET_PATH),
            String.format("/%s/confirmations/*", RestImplConfig.SERVLET_PATH))
        .permitAll()
        //.hasRole(Roles.NOT_CONFIRMED)
        .antMatchers(String.format("/%s/**", RestImplConfig.SERVLET_PATH))
        .hasRole(Roles.CONFIRMED)
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(
            new EmailPasswordAuthenticationFilter(authenticationManagerBean()),
            RequestCacheAwareFilter.class)
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
        .authenticationProvider(emailPasswordAuthenticationProvider)
        .authenticationProvider(jwtAuthenticationProvider);
  }
}
