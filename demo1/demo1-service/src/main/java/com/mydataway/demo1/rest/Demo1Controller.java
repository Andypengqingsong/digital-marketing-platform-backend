package com.mydataway.demo1.rest;

import com.mydataway.demo1.service.Demo1Service;
import com.mydataway.demo1.service.Demo1TaskService;
import com.xxl.job.admin.core.model.XxlJobInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "demo1", tags = "demo1")
public class Demo1Controller {

    @Autowired
    private Demo1Service demo1Service;

    @Autowired
    private Demo1TaskService demo1TaskService;

    @GetMapping("/hello-demo1")
    @ApiOperation("跟demo1說你好")
    public String helloDemo1(@ApiParam(name = "param", required = true, value = "test") @RequestParam String param,
                             @ApiParam(name = "param2", required = true, value = "test2") @RequestParam String param2) {
        return "demo1 contoller -> " + demo1Service.helloDemo1();
    }

    @GetMapping("/hello-demo2")
    @ApiOperation("跟demo2說你好")
    public String helloDemo2() {
        return "demo1 controller -> " + demo1Service.helloDemo2();
    }

    @GetMapping("/create-task")
    @ApiOperation("創建一個測試任務")
    public XxlJobInfo createTask() {

        XxlJobInfo xxlJobInfo = new XxlJobInfo();

        xxlJobInfo.setJobGroupName("demo2");//执行器名称，和模块配置中的xxl.job.executor.appname一致
        xxlJobInfo.setJobCron("0/10 * * * * ?");//cron表达式
        xxlJobInfo.setJobDesc("auto-create-task1");//任务描述
        xxlJobInfo.setExecutorParam("this is parameter");//任务执行参数
        xxlJobInfo.setAuthor("adminnn");//创建该任务的登录账号
        xxlJobInfo.setExecutorRouteStrategy("FIRST");//执行策略
        xxlJobInfo.setExecutorBlockStrategy("SERIAL_EXECUTION");//阻塞策略
        xxlJobInfo.setGlueType("BEAN");//执行模式
        xxlJobInfo.setTriggerStatus(1);//状态，1启用，2停用
        xxlJobInfo.setExecutorHandler("demoJob2");//处理器名称，和处理器中@XxlJob注解的值一致

        demo1TaskService.createTask(xxlJobInfo);
        return xxlJobInfo;
    }
}
