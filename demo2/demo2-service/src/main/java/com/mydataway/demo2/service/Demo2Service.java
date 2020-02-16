package com.mydataway.demo2.service;

import com.mydataway.demo1.api.Demo1Api;
import com.mydataway.demo2.api.Demo2Api;
import com.mydataway.demo2.dao.Demo2Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yatu on 17/5/8.
 */
@RestController
@RequestMapping("/api")
public class Demo2Service implements Demo2Api {

    @Autowired
    private Demo2Repo demo2Repo;
    @Autowired
    @Qualifier("Demo1Api")
    private Demo1Api demo1Api;

    public String helloDemo1() {
        return "demo2 service -> " + demo1Api.helloDemo1();
    }

    public String helloDemo2() {
        return "demo2 service -> " + demo2Repo.getDemo2List();
    }
}
