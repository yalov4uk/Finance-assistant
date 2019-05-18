package com.perfect.team.common.client.config;

import com.perfect.team.common.client.FeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class CommonClientConfig {

  @Bean
  public RequestInterceptor requestInterceptor() {
    return new FeignRequestInterceptor();
  }
}
