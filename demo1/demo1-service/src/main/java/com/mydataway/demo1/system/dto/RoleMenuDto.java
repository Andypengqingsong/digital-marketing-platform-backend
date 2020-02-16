package com.mydataway.demo1.system.dto;

import com.mydataway.demo1.system.domain.Menu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭青松
 * @project wxws-frameworkcom.mydataway.demo1.system.dto
 * @company 我行我数
 * @date 2020/2/17 1:18
 * @description 描述当前类的用途
 */
@Data
public class RoleMenuDto {

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
    List<Menu> menus = new ArrayList<>();
}
