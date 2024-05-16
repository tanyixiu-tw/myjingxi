package com.jingxi.myjingxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MyjingxiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyjingxiApplication.class, args);
    }

}
