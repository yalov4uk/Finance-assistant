package com.perfect.team.legacy.client.config;

import feign.Contract;
import feign.jaxrs.JAXRSContract;
import org.springframework.context.annotation.Bean;

public class LegacyClientFeignConfig {

  @Bean
  public Contract feignContract() {
    return new JAXRSContract();
  }
}
