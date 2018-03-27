package com.perfect.team.rest.impl.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;

@Configuration
public class RestImplConfiguration {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
