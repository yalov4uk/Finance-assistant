package com.perfect.team.business.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@PropertySource("classpath:config/business.properties")
@Configuration
@Component
public class FacebookProperties {

  @Value("${facebook.api.version}")
  public String apiVersion;

  @Value("${facebook.app.id}")
  public String appId;

  @Value("${facebook.app.secret}")
  public String appSecret;
}
