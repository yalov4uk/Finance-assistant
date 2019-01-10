package com.perfect.team.auth.imp.config;

import java.util.Arrays;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public Mapper dozerMapper() {
    DozerBeanMapper dozerBean = new DozerBeanMapper();
    List<String> mappingFiles = Arrays.asList(
        "classpath:dozer-configuration.xml",
        "classpath:mapping/auth-mapping.xml"
    );
    dozerBean.setMappingFiles(mappingFiles);
    return dozerBean;
  }
}
