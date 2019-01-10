package com.perfect.team.auth.imp.security;

import static com.perfect.team.common.security.Role.EMAIL;
import static org.springframework.http.HttpMethod.POST;

import com.perfect.team.auth.imp.middleware.UsernamePasswordAuthenticationFilter;
import com.perfect.team.common.security.CommonWebSecurityConfig;
import com.perfect.team.common.security.JwtAuthenticationProvider;
import java.util.Arrays;
import java.util.stream.Stream;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;

@EnableWebSecurity
public class WebSecurityConfig extends CommonWebSecurityConfig {

  private final UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;

  public WebSecurityConfig(JwtAuthenticationProvider jwtAuthenticationProvider,
      UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider) {
    super(jwtAuthenticationProvider);
    this.usernamePasswordAuthenticationProvider = usernamePasswordAuthenticationProvider;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    super.configure(http);
    http.addFilterBefore(new UsernamePasswordAuthenticationFilter(authenticationManagerBean()),
        RequestCacheAwareFilter.class)
        .authorizeRequests()
        .antMatchers(POST, "/credentials")
        .permitAll()
        .antMatchers("/signIn")
        .hasRole(EMAIL.name());
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    super.configure(auth);
    auth.authenticationProvider(usernamePasswordAuthenticationProvider);
  }

  @Override
  protected String[] permitAll() {
    return Stream.concat(Arrays.stream(super.permitAll()), Stream.of("/token"))
        .toArray(String[]::new);
  }
}
