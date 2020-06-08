package com.shiro2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.shiro2.mapper")
@ServletComponentScan("com.shiro2.filters")
public class Shiro2Application {

    public static void main(String[] args) {
        SpringApplication.run(Shiro2Application.class, args);
    }

}
