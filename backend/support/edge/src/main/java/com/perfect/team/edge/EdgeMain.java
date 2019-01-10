package com.perfect.team.edge;

import com.perfect.team.auth.client.TokenClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients(clients = {TokenClient.class})
@EnableZuulProxy
@SpringBootApplication
public class EdgeMain {

  public static void main(String[] args) {
    SpringApplication.run(EdgeMain.class, args);
  }
}
