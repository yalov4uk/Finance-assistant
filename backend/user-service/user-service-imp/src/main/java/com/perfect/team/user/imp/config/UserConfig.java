package com.perfect.team.user.imp.config;

import java.util.Arrays;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

  @Bean
  public Mapper dozerMapper() {
    DozerBeanMapper dozerBean = new DozerBeanMapper();
    List<String> mappingFiles = Arrays.asList(
        "classpath:dozer-configuration.xml",
        "classpath:mappings/user-mappings.xml"
    );
    dozerBean.setMappingFiles(mappingFiles);
    return dozerBean;
  }
}
