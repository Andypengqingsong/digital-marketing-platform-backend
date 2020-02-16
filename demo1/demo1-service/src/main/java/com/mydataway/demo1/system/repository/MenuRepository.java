package com.mydataway.demo1.system.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mydataway.demo1.system.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuRepository extends BaseMapper<Menu> {
}
