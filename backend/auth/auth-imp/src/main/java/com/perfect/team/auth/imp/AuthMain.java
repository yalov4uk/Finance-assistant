package com.perfect.team.auth.imp;

import com.perfect.team.auth.imp.repository.CredentialMapper;
import com.perfect.team.common.config.CommonImpConfig;
import com.perfect.team.legacy.client.UserClient;
import com.perfect.team.legacy.client.config.LegacyClientFeignConfig;
import com.perfect.team.legacy.client.config.LegacyClientValidationConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@EnableEurekaClient
@EnableFeignClients(clients = UserClient.class)
@MapperScan(basePackageClasses = CredentialMapper.class)
@Import({CommonImpConfig.class, LegacyClientFeignConfig.class, LegacyClientValidationConfig.class})
@SpringBootApplication
public class AuthMain {

  public static void main(String[] args) {
    SpringApplication.run(AuthMain.class, args);
  }
}
