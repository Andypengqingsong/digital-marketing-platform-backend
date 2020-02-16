package com.mydataway.demo2.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

@Component
public class DemoJob {

    @XxlJob("demoJob2")
    public ReturnT<String> demoJob2(String param) throws Exception {

        System.out.println("Hello xxl task,this demoJob2 , param: " + param);
        return ReturnT.SUCCESS;
    }

}
