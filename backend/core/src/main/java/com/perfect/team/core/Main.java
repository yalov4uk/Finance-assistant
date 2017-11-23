package com.perfect.team.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.perfect.team")
@EnableJpaRepositories(basePackages = "com.perfect.team.business.repository")
@EntityScan(basePackages = "com.perfect.team.business.entity")
@MapperScan(basePackages = "com.perfect.team.business.repository.mybatis")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
