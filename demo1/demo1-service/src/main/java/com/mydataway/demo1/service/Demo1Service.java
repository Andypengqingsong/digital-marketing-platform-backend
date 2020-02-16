package com.mydataway.demo1.service;

import com.mydataway.demo1.dao.Demo1Repo;
import com.mydataway.demo1.api.Demo1Api;
import com.mydataway.demo2.api.Demo2Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yatu on 17/5/8.
 */
@RestController
@RequestMapping("/api")
public class Demo1Service implements Demo1Api {

    @Autowired
    private Demo1Repo demo1Repo;

    @Autowired
    private Demo2Api demo2Api;

    public String helloDemo1() {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "demo1 service -> " + demo1Repo.getDemo1List();
    }

    public String helloDemo2() {
        return "demo1 service -> " + demo2Api.helloDemo2();
    }

}
