package com.mydataway.api.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @RequestMapping(method = RequestMethod.HEAD)
    public String healthCheck() {
        return String.valueOf(System.currentTimeMillis());
    }
}
