package com.ethan.forum.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ethan.forum.dao")
public class MybatisConfig {

}
