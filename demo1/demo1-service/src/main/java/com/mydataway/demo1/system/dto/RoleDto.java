package com.mydataway.demo1.system.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author 彭青松
 * @project wxws-frameworkcom.mydataway.demo1.system.dto
 * @company 我行我数
 * @date 2020/2/17 0:43
 * @description 描述当前类的用途
 */
@Data
public class RoleDto {

    private Long id;

    private String name;

    /**
     * 数据权限类型 全部 、 本级 、 自定义
     */
    private String dataScope = "本级";

    /**
     * 数值越小，级别越大
     */
    private Integer level = 3;

    private String remark;

    /**
     * 权限
     */
    private String permission;

    private Date createTime;
}
