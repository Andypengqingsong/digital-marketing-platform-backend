package com.mydataway.demo1.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author calvinkun
 * @date 2020/2/15 15:51
 */
@TableName("t_user_role")
@Data
public class UserRole {

    private Long id;

    private Long userId;

    private Long roleId;

}
