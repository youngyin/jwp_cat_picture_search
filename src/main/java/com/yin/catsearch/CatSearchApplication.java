package com.yin.catsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@EnableFeignClients
@SpringBootApplication
@PropertySource("classpath:/key.properties")
public class CatSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatSearchApplication.class, args);
    }

}
