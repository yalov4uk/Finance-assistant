package com.perfect.team.business.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.perfect.team.business.mapper")
public class BusinessConfig {

}
