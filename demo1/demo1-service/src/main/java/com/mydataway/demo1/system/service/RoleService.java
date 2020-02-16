package com.mydataway.demo1.system.service;

import com.mydataway.demo1.system.dto.RoleDto;
import com.mydataway.demo1.system.dto.RoleMenuDto;
import com.mydataway.demo1.system.dto.RoleQueryDto;

import java.util.List;
import java.util.Set;

public interface RoleService {
    RoleDto findById(Long id);

    List<RoleDto> queryAll(RoleQueryDto roleQueryDto);

    void save(RoleDto roleDto);

    void update(RoleDto roleDto);


    void delete(Set<Long> ids);

    void updateMenu(RoleMenuDto roleMenuDto);
}
