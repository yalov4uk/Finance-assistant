package com.perfect.team.legacy.client.config;

import com.perfect.team.legacy.client.UserClient;
import com.perfect.team.legacy.client.validation.UserIdClientValidator;
import org.springframework.context.annotation.Bean;

public class LegacyClientValidationConfig {

  @Bean
  public UserIdClientValidator userIdClientValidator(UserClient userClient) {
    return new UserIdClientValidator(userClient);
  }
}
