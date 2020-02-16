package com.mydataway.demo1.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author calvinkun
 * @date 2020/2/15 15:51
 */
@TableName("t_user_menu")
@Data
public class RoleMenu {

    private Long id;

    private Long roleId;

    private Long menuId;

}
