package com.perfect.team.edge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class EdgeMain {

  public static void main(String[] args) {
    SpringApplication.run(EdgeMain.class, args);
  }
}
