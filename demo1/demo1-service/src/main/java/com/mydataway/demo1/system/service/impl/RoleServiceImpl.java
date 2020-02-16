package com.mydataway.demo1.system.service.impl;

import com.mydataway.demo1.system.domain.Menu;
import com.mydataway.demo1.system.domain.Role;
import com.mydataway.demo1.system.domain.User;
import com.mydataway.demo1.system.dto.*;
import com.mydataway.demo1.system.repository.MenuRepository;
import com.mydataway.demo1.system.repository.RoleRepository;
import com.mydataway.demo1.system.repository.UserRepository;
import com.mydataway.demo1.system.service.RoleService;
import com.mydataway.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author calvinkun
 * @date 2020/2/16 0016 18:14
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public RoleDto findById(Long id) {
        Role role = roleRepository.selectById(id);
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(role, roleDto);
        return roleDto;
    }

    @Override
    public List<RoleDto> queryAll(RoleQueryDto roleQueryDto) {
        List<Role> roles = roleRepository.queryAll();
        List<RoleDto> roleDtos = new ArrayList<>();
        for (Role role : roles) {
            RoleDto roleDto = new RoleDto();
            BeanUtils.copyProperties(role, roleDto);
            roleDtos.add(roleDto);
        }
        return roleDtos;
    }

    @Override
    public void save(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        roleRepository.insert(role);
    }

    @Override
    public void update(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        roleRepository.updateById(role);
    }


    @Override
    public void delete(Set<Long> ids) {
        roleRepository.deleteBatchIds(ids);
    }


    @Override
    public Collection<GrantedAuthority> mapToGrantedAuthorities(User user) {
        Set<RoleMenuDto> roleMenuDtos = findByUserId(user.getId());
        Set<String> permissions = roleMenuDtos.stream().filter(roleMenuDto -> StringUtils.isNotBlank(roleMenuDto.getPermission())).map(RoleMenuDto::getPermission).collect(Collectors.toSet());
        permissions.addAll(
                roleMenuDtos.stream().flatMap(roleMenuDto -> roleMenuDto.getMenus().stream())
                        .filter(menu -> StringUtils.isNotBlank(menu.getPermission()))
                        .map(Menu::getPermission).collect(Collectors.toSet())
        );
        return permissions.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public void updateMenu(RoleMenuUpdateDto roleMenuUpdateDto) {
        for (MenuDto menuDto : roleMenuUpdateDto.getMenuDtos()) {
            Menu menu = new Menu();
            BeanUtils.copyProperties(menuDto, menu);
            menuRepository.insert(menu);
        }
    }

    private Set<RoleMenuDto> findByUserId(Long id) {
        List<Role> roles = userRepository.selectRoleByUserId(id);
        Set<RoleMenuDto> roleMenuDtos = new HashSet<>();
        for (Role role : roles) {
            List<Menu> menus = roleRepository.selectMenuByRoleId(role.getId());
            RoleMenuDto roleMenuDto = new RoleMenuDto();
            BeanUtils.copyProperties(role, roleMenuDto);
            roleMenuDto.setMenus(menus);
            roleMenuDtos.add(roleMenuDto);
        }
        return roleMenuDtos;
    }

}
