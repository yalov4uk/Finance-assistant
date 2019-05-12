package com.perfect.team.auth.imp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("facebook")
public class FacebookProperties {

  public String apiVersion;
  public String appId;
  public String appSecret;
}
