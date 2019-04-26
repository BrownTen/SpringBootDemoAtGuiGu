package com.wyt.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllar {

    @Value("${person.lastName}")
    private String name;

    @RequestMapping("/sayHello")
    public String hello(){
        return "hello" + name;
    }
}
