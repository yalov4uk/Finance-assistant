package com.perfect.team.user.client.config;

import com.perfect.team.user.client.UserClient;
import com.perfect.team.user.client.validation.UserIdClientValidator;
import org.springframework.context.annotation.Bean;

public class UserClientConfig {

  @Bean
  public UserIdClientValidator userIdClientValidator(UserClient userClient) {
    return new UserIdClientValidator(userClient);
  }
}
