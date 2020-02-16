package com.mydataway.demo1.system.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author calvinkun
 * @date 2020/2/16 0016 23:04
 */
@Data
public class EnterpriseStatusDto {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "状态：1正常、0禁用", required = true)
    private Integer status;

}
