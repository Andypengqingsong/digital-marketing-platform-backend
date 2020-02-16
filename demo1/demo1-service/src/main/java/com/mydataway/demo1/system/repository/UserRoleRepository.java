package com.mydataway.demo1.system.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mydataway.demo1.system.domain.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleRepository extends BaseMapper<UserRole> {
}
