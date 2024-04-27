package com.codemyth.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeService {

    public void printMessage(String message) {
        log.info("Hello Message: " + message);
    }
}
