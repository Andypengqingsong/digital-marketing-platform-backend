package com.mydataway.demo1.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author calvinkun
 * @date 2020/2/15 15:51
 */
@TableName("t_user")
@Data
public class User {

    private Long id;

    private String userName;

    /** 用户昵称 */
    private String nickName;

    /** 性别 */
    private String sex;

    private String phone;

    private Integer enabled;

    private String password;

    private Date createTime;

    private Date lastPasswordResetTime;

    private Long enterpriseId;
}
