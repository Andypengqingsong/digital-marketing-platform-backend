package com.mydataway.demo1.service;

import com.mydataway.demo1.api.Demo1TaskApi;
import com.xxl.job.admin.client.XxlJobClient;
import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.core.biz.model.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yatu on 17/5/8.
 */
@Service
public class Demo1TaskService implements Demo1TaskApi {

    @Autowired
    private XxlJobClient xxlJobClient;

    @Override
    public void createTask(XxlJobInfo xxlJobInfo) {

        ReturnT<String> newId = xxlJobClient.add(xxlJobInfo);
        System.out.println("newId : " + newId.toString());
    }
}
