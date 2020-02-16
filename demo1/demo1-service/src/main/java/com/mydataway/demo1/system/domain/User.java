package com.mydataway.demo1.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author calvinkun
 * @date 2020/2/15 0015 15:51
 */
@TableName("t_user")
@Data
public class User {

    private Long id;

    private String name;
}
