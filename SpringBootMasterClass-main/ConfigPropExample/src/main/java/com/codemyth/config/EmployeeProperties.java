package com.codemyth.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ConfigurationProperties(prefix = "employee")
@PropertySource(value = "classpath:application.properties")
@Data
public class EmployeeProperties {

    @Value("${employee.name}")
    private String name;
    @Value("${employee.age}")
    private Integer age;
}
