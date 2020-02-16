package com.mydataway.demo1.system.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author calvinkun
 * @date 2020/2/16 0016 23:04
 */
@Data
public class EnterpriseQueryDto {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "编码")
    private String number;

    @ApiModelProperty(value = "当前页", required = true)
    private Integer pageNum;

    @ApiModelProperty(value = "每页数量", required = true)
    private Integer pageSize;
}
