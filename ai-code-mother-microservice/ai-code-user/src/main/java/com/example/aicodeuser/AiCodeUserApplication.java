package com.example.aicodeuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.aicodeuser.mapper")
@ComponentScan("com.example")
public class AiCodeUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiCodeUserApplication.class, args);
    }
}