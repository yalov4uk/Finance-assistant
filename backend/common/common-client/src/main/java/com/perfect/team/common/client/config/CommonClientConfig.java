package com.perfect.team.common.client.config;

import com.perfect.team.common.client.FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;

public class CommonClientConfig {

  @Bean
  public FeignRequestInterceptor feignRequestInterceptor() {
    return new FeignRequestInterceptor();
  }
}
