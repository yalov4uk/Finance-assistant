package com.perfect.team.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.perfect.team")
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}
