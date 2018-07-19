package com.perfect.team.rest.impl.config;

import java.util.Arrays;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestImplConfig {

  public static final String SERVLET_PATH = "api/v2.1";

  @Bean(name = "org.dozer.Mapper")
  public DozerBeanMapper dozerMapper() {
    DozerBeanMapper dozerBean = new DozerBeanMapper();
    List<String> mappingFiles = Arrays.asList(
        "classpath:dozer-configuration.xml",
        "classpath:mappings/account-mappings.xml",
        "classpath:mappings/category-mappings.xml",
        "classpath:mappings/transaction-mappings.xml",
        "classpath:mappings/transfer-mappings.xml",
        "classpath:mappings/user-mappings.xml",
        "classpath:mappings/confirmation-mappings.xml"
    );
    dozerBean.setMappingFiles(mappingFiles);
    return dozerBean;
  }
}
