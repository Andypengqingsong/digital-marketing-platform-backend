package com.xxl.job.admin.client;

import com.xxl.job.admin.service.XxlJobService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "xxl-job-admin",path = "/xxl-job/api")
public interface XxlJobClient extends XxlJobService {
}
