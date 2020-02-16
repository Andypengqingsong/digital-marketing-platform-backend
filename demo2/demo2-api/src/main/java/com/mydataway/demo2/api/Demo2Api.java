package com.mydataway.demo2.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "demo2", path = "/api")
public interface Demo2Api {

    @GetMapping("/hello-demo1")
    String helloDemo1();

    @GetMapping("/hello-demo2")
    String helloDemo2();

}
