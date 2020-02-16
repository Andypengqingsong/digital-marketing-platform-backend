package com.xxl.job.admin.service;


import com.xxl.job.admin.annotation.ClientPermissionLimit;
import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.core.biz.model.ReturnT;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * core job action for xxl-job
 * 
 * @author xuxueli 2016-5-28 15:30:33
 */
public interface XxlJobService {

	/**
	 * page list
	 *
	 * @param start
	 * @param length
	 * @param jobGroup
	 * @param jobDesc
	 * @param executorHandler
	 * @param author
	 * @return
	 */
	@PostMapping("/list")
	public Map<String, Object> pageList(@RequestParam("start")int start,
										@RequestParam("length")int length,
										@RequestParam("jobGroup")int jobGroup,
										@RequestParam("triggerStatus")int triggerStatus,
										@RequestParam("jobDesc")String jobDesc,
										@RequestParam("executorHandler")String executorHandler,
										@RequestParam("author")String author);

	/**
	 * add job
	 *
	 * @param jobInfo
	 * @return
	 */
	@PostMapping("/xxl-task")
	@ClientPermissionLimit
	public ReturnT<String> add(@RequestBody XxlJobInfo jobInfo);

	/**
	 * update job
	 *
	 * @param jobInfo
	 * @return
	 */
	@PutMapping("/xxl-task")
	public ReturnT<String> update(XxlJobInfo jobInfo);

	/**
	 * remove job
	 * 	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("/xxl-task")
	public ReturnT<String> remove(int id);

	/**
	 * start job
	 *
	 * @param id
	 * @return
	 */
	@PostMapping("/start")
	public ReturnT<String> start(int id);

	/**
	 * stop job
	 *
	 * @param id
	 * @return
	 */
	@PostMapping("/stop")
	public ReturnT<String> stop(int id);

	/**
	 * dashboard info
	 *
	 * @return
	 */
	@GetMapping("/dashboard-info")
	public Map<String,Object> dashboardInfo();

	/**
	 * chart info
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@PostMapping("/chart-info")
	public ReturnT<Map<String,Object>> chartInfo(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate);

}
