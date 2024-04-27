package com.codemyth;

import com.codemyth.config.EmployeeProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ConfigPropExampleApplication implements CommandLineRunner {

    @Autowired
    private EmployeeProperties employeeProperties;

    public static void main(String[] args) {
        SpringApplication.run(ConfigPropExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Properties: " + employeeProperties.toString());
    }
}
