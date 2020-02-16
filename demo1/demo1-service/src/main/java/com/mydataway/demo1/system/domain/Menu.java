package com.mydataway.demo1.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author calvinkun
 * @date 2020/2/16 0016 18:44
 */
@TableName("t_menu")
@Data
public class Menu {

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

    private Date createTime;
}
