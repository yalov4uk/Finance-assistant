package com.perfect.team.auth.imp;

import com.perfect.team.common.config.CommonImpConfig;
import com.perfect.team.user.client.UserClient;
import com.perfect.team.user.client.config.UserClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(clients = UserClient.class)
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@Import({CommonImpConfig.class, UserClientConfig.class})
public class AuthMain {

  public static void main(String[] args) {
    SpringApplication.run(AuthMain.class, args);
  }
}
