package com.mydataway.demo1.system.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mydataway.demo1.system.domain.Menu;
import com.mydataway.demo1.system.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

@Mapper
public interface RoleRepository extends BaseMapper<Role> {
    @Select("select * from  t_role ")
    List<Role> queryAll();


    /**
     * 根据用户ID查询
     *
     * @param id 用户ID
     * @return
     */
    Set<Role> findByUsers_Id(Long id);


    @Select("SELECT tm.* FROM t_menu tm ,t_role_menu trm ,t_role tr WHERE  tr.id=trm.role_id AND trm.menu_id=tm.id AND tr.id=#{id} ")
    List<Menu> selectMenuByRoleId(@Param("id") Long id);
}
