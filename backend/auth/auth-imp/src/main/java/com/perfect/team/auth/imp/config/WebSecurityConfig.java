package com.perfect.team.auth.imp.config;

import com.perfect.team.auth.imp.middleware.UsernamePasswordAuthenticationFilter;
import com.perfect.team.auth.imp.security.UsernamePasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;

//@EnableWebSecurity
public class WebSecurityConfig /*extends WebSecurityConfigurerAdapter*/{

//  @Autowired
  private UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;

//  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/swagger*").permitAll()
//        .antMatchers("/signIn").hasRole(Role.EMAIL.name())
//        .antMatchers("/signIn*").permitAll()
        .antMatchers("/**").permitAll()
        .anyRequest().authenticated()
        .and()
//        .addFilterBefore(new UsernamePasswordAuthenticationFilter(authenticationManagerBean()),
//            RequestCacheAwareFilter.class)
        .csrf().disable()
        .logout().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

//  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .authenticationProvider(usernamePasswordAuthenticationProvider);
  }
}
