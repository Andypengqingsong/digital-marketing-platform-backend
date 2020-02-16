package com.mydataway.demo1.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author calvinkun
 * @date 2020/2/16 0016 18:16
 */
@TableName("t_enterprise")
@Data
public class Enterprise {

    private Long id;

    private String name;

    //全称
    private String full_name;

    //企业编码
    private String number;

    //状态：1正常、0禁用
    private Integer status;

    //行业
    private String industry;

    //上级公司
    private String parentCompany;

    private Date createTime;

    private Date updateTime;

}
