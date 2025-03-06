package com.demo.controller;

import com.demo.model.TestEntity;
import com.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DemoService service;

    @GetMapping("/demo")
    public ResponseEntity<List<TestEntity>> get() throws Exception {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/token")
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }

 
}
