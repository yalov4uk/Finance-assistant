package com.perfect.team.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.perfect.team")
@MapperScan(basePackages = "com.perfect.team.business.mapper")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
