package com.perfect.team.common.api.config;

import feign.Contract;
import feign.jaxrs.JAXRSContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

  @Bean
  public Contract feignContract() {
    return new JAXRSContract();
  }
}
