package com.perfect.team.credential.imp.config;

import java.util.Arrays;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CredentialConfig {

  @Bean
  public Mapper dozerMapper() {
    DozerBeanMapper dozerBean = new DozerBeanMapper();
    List<String> mappingFiles = Arrays.asList(
        "classpath:dozer-configuration.xml",
        "classpath:mapping/credential-mapping.xml"
    );
    dozerBean.setMappingFiles(mappingFiles);
    return dozerBean;
  }
}
