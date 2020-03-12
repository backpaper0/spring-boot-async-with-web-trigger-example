package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringBootAsyncWithWebTriggerExampleApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SpringBootAsyncWithWebTriggerExampleApplication.class, args);
    }

}
