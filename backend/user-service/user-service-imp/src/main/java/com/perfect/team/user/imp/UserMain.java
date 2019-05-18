package com.perfect.team.user.imp;

import com.perfect.team.common.config.CommonImpConfig;
import com.perfect.team.user.imp.repository.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@MapperScan(basePackageClasses = UserMapper.class)
@Import(CommonImpConfig.class)
public class UserMain {

  public static void main(String[] args) {
    SpringApplication.run(UserMain.class, args);
  }
}
