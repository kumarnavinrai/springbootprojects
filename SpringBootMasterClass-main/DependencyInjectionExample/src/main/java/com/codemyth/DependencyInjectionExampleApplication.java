package com.codemyth;

import com.codemyth.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DependencyInjectionExampleApplication implements CommandLineRunner {


    private final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.printMessage("Cons Injection Example");
    }


}
