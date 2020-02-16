package com.mydataway.demo1.system.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mydataway.demo1.system.domain.Enterprise;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMenuRepository extends BaseMapper<Enterprise> {
}
