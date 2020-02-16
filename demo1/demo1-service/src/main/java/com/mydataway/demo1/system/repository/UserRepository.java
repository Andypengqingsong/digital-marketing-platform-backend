package com.mydataway.demo1.system.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
}
