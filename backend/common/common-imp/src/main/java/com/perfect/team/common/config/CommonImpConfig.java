package com.perfect.team.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfect.team.common.middleware.TimeFilter;
import com.perfect.team.common.security.JwtAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(JmsConfig.class)
public class CommonImpConfig {

  @Bean
  public TimeFilter timeFilter() {
    return new TimeFilter();
  }

  @Bean
  public JwtAuthenticationProvider jwtAuthenticationProvider(ObjectMapper objectMapper) {
    return new JwtAuthenticationProvider(objectMapper);
  }
}
