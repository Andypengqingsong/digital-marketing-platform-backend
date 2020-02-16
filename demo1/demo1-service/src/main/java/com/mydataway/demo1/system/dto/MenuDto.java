package com.mydataway.demo1.system.dto;

import java.util.Date;

/**
 * @author 彭青松
 * @project wxws-frameworkcom.mydataway.demo1.system.dto
 * @company 我行我数
 * @date 2020/2/17 1:18
 * @description 描述当前类的用途
 */
public class MenuDto {
    private Long id;

    private String name;

    private Long sort = 999L;

    private String path;

    private String component;

    /** 类型，目录、菜单、按钮 */
    private Integer type;

    /** 权限 */
    private String permission;

    private String componentName;

    private String icon;

    private Boolean cache;

    private Boolean hidden;

    /** 上级菜单ID */
    private Long pid;

    /** 是否为外链 true/false */
    private Boolean iFrame;

}
