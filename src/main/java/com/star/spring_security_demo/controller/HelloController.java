package com.star.spring_security_demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String greet(HttpServletRequest request) {
        System.out.println("This is the session ID : " + request.getSession().getId());
        return "Hello World ";
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request) {
        return "star " + request.getSession().getId();
    }
}
