package com.mydataway.demo2.rest;

import com.mydataway.demo2.service.Demo2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo2Controller {

    @Autowired
    private Demo2Service demo2Service;

    @GetMapping("/hello-demo1")
    public String helloDemo1() {
        return "demo2 contoller -> " + demo2Service.helloDemo1();
    }

    @GetMapping("/hello-demo2")
    public String helloDemo2() {
        return "demo2 controller -> " + demo2Service.helloDemo2();
    }
}
