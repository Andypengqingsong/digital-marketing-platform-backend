package com.mydataway.demo1.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

@Component
public class DemoJob{

    @XxlJob("demoJob")
    public ReturnT<String> demoJob(String param) throws Exception {

        System.out.println("Hello xxl task,param: " + param);
        return ReturnT.SUCCESS;
    }

}
