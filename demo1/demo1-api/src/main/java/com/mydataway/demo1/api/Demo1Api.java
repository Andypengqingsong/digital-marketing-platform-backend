package com.mydataway.demo1.api;

import com.mydataway.demo1.fallback.DemoFallback;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(qualifier = "Demo1Api",name = "demo1", path = "/api",fallback = DemoFallback.class)
public interface Demo1Api {

    @GetMapping("/hello-demo1")
    @ApiOperation("跟demo1說你好-feign調用")
    String helloDemo1();

    @GetMapping("/hello-demo2")
    @ApiOperation("跟demo2說你好-feign調用")
    String helloDemo2();

}
