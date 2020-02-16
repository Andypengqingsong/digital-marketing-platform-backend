package com.mydataway.demo1.system.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mydataway.demo1.system.domain.Role;
import com.mydataway.demo1.system.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepository extends BaseMapper<User> {

    @Select("select * from  t_user where username =  #{username}")
    User findByUsername(@Param("username") String username);


    @Select("select * from  t_user ")
    List<User> queryAll();


    @Select("SELECT tr.* FROM t_user tu ,t_user_role tur ,t_role tr WHERE  tu.id=tur.user_id AND tur.role_id=tr.id AND tu.id=#{id}")
    List<Role> selectRoleByUserId(@Param("id") Long id);
}
