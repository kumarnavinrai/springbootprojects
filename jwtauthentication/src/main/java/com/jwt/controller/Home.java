package com.jwt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Home {

    @RequestMapping("/welcome")
    public String welcome() {
        String text = "this is private page ";
        text+= "this page is allowed to unauthenticated users";
        return text;
    }

    @GetMapping("/testproduct")
    public String testproduct() {
        String text = "this is private page ";
        text+= "this page is allowed to testproduct testproduct";
        return text;
    }


    @RequestMapping("/getusers")
    public String getUser() {
        return "{\"name\":\"Durgesh\"}";
    }

}
