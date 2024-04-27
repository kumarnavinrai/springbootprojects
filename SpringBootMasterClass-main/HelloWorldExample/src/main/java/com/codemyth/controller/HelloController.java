package com.codemyth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    //    localhost:8080/api/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!!";
    }
}
