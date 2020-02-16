package com.mydataway.demo1.system.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author calvinkun
 * @date 2020/2/16 0016 23:04
 */
@Data
public class EnterpriseInsertDto {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "编码", required = true)
    private String number;

    @ApiModelProperty(value = "全称", required = true)
    private String fullName;

    @ApiModelProperty(value = "状态：1正常、0禁用", required = true)
    private Integer status;

    @ApiModelProperty(value = "行业", required = true)
    private String industry;

    @ApiModelProperty(value = "上级公司")
    private String parentCompany;

}
