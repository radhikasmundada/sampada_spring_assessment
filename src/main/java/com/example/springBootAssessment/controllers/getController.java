package com.example.springBootAssessment.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/get")
public class getController {

    @GetMapping("/")
    public String get(){
        return "Hello, World!";
    }

}
