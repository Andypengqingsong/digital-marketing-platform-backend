package com.mydataway.demo1.system.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author 彭青松
 * @project wxws-frameworkcom.mydataway.demo1.system.dto
 * @company 我行我数
 * @date 2020/2/16 23:42
 * @description 描述当前类的用途
 */
@Data
public class UserDto {

    private String username;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private String sex;

    private String phone;

    private Integer enabled;

    private String password;


    private Long enterpriseId;
}
