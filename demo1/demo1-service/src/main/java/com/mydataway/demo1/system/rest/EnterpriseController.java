package com.mydataway.demo1.system.rest;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mydataway.base.BusinessResponse;
import com.mydataway.base.CommonResponseEnum;
import com.mydataway.demo1.system.domain.Enterprise;
import com.mydataway.demo1.system.service.EnterpriseService;
import com.mydataway.demo1.system.service.dto.EnterpriseInsertDto;
import com.mydataway.demo1.system.service.dto.EnterpriseQueryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author calvinkun
 * @date 2020/2/15 15:55
 */
@RestController
@Api(tags = "系统：企业管理")
@RequestMapping("/api/enter-prize")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @ApiOperation("企业列表")
    @PostMapping(value = "/list")
//    @PreAuthorize("@el.check('enterprise:list')")
    public BusinessResponse list(@RequestBody EnterpriseQueryDto enterpriseQueryDto){
        IPage<Enterprise> pageList = enterpriseService.queryEnterPriseList(enterpriseQueryDto);
        JSONObject js = new JSONObject();
        js.put("total",pageList.getTotal());
        js.put("pageNum",enterpriseQueryDto.getPageNum());
        js.put("pageSize",enterpriseQueryDto.getPageSize());
        js.put("items",pageList.getRecords());
        return new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(),CommonResponseEnum.SUCCESS.getmsg(),js);
    }

    @ApiOperation("新增企业")
    @PostMapping(value = "/add")
//    @PreAuthorize("@el.check('enterprise:add')")
    public BusinessResponse add(@RequestBody EnterpriseInsertDto enterpriseInsertDto){
        if (enterpriseService.queryByName(enterpriseInsertDto.getName()) != null) {
            return new BusinessResponse(CommonResponseEnum.FAIL.getCode(),"企业名称存在");
        }
        if (enterpriseService.queryByNumber(enterpriseInsertDto.getNumber()) != null) {
            return new BusinessResponse(CommonResponseEnum.FAIL.getCode(),"企业编码存在");
        }
        if (enterpriseService.queryByFullName(enterpriseInsertDto.getFullName()) != null) {
            return new BusinessResponse(CommonResponseEnum.FAIL.getCode(),"企业全称存在");
        }
        Enterprise enterprise = new Enterprise();
        BeanUtils.copyProperties(enterpriseInsertDto,enterprise);
        enterpriseService.saveEnterprise(enterprise);
        return new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(),CommonResponseEnum.SUCCESS.getmsg());
    }

    @ApiOperation("修改企业信息")
    @PostMapping(value = "/update")
//    @PreAuthorize("@el.check('enterprise:update')")
    public BusinessResponse update(@RequestBody EnterpriseInsertDto enterpriseInsertDto){
        Enterprise enterprise = new Enterprise();
        BeanUtils.copyProperties(enterpriseInsertDto,enterprise);
        enterpriseService.updateEnterprise(enterprise);
        return new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(),CommonResponseEnum.SUCCESS.getmsg());
    }




}
