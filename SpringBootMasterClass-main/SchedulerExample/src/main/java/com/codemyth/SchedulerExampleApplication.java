package com.codemyth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulerExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerExampleApplication.class, args);
    }

}
