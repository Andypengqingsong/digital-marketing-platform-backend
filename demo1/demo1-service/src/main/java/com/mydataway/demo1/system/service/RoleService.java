package com.mydataway.demo1.system.service;

import com.mydataway.demo1.system.domain.User;
import com.mydataway.demo1.system.dto.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface RoleService {
    RoleDto findById(Long id);

    List<RoleDto> queryAll(RoleQueryDto roleQueryDto);

    void save(RoleDto roleDto);

    void update(RoleDto roleDto);


    void delete(Set<Long> ids);


    /**
     * 获取用户权限信息
     * @param user 用户信息
     * @return 权限信息
     */
    Collection<GrantedAuthority> mapToGrantedAuthorities(User user);


    void updateMenu(RoleMenuUpdateDto roleMenuUpdateDto);
}
