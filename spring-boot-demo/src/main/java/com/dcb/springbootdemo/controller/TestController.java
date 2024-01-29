package com.dcb.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class TestController {
    @GetMapping("/")
    public  String testServ(){
            System.out.println("this is feature branch");
        return "welcome to spring boot app";
    }
}
