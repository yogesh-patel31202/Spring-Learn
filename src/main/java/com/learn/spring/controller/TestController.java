package com.learn.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/test")
@RestController
public class TestController {


    @GetMapping
    public ResponseEntity<String> getTest() {
        return ResponseEntity.ok("Test successful.");
    }

/*
    @GetMapping("/get2")
    public ResponseEntity<String> getTest1() {
        return ResponseEntity.ok("Test 2 successful.");
    }*/


}
