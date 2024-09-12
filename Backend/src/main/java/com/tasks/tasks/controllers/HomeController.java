package com.tasks.tasks.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HomeController {

    @GetMapping("/")
    public String requestMethodName() {
        return "Hello World!";
    }
    
}
