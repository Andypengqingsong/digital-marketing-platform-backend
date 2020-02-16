package com.mydataway.demo1.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author calvinkun
 * @date 2020/2/16 0016 18:24
 */
@TableName("t_role")
@Data
public class Role {
    private Long id;

    private String name;

    /** 数据权限类型 全部 、 本级 、 自定义 */
    private String dataScope = "本级";

    /** 数值越小，级别越大 */
    private Integer level = 3;

    private String remark;

    /** 权限 */
    private String permission;

    private Date createTime;
}
