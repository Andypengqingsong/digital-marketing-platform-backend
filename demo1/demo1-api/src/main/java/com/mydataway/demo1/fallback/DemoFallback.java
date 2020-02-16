package com.mydataway.demo1.fallback;

import com.mydataway.demo1.api.Demo1Api;
import org.springframework.stereotype.Component;

@Component
public class DemoFallback implements Demo1Api {

    @Override
    public String helloDemo1() {
        System.out.println("Demo1Client fall back");
        return "Fallback Demo1";
    }

    @Override
    public String helloDemo2() {
        return null;
    }

}
