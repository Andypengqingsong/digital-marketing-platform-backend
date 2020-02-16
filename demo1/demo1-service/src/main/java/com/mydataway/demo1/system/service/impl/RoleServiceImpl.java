package com.mydataway.demo1.system.service.impl;

import com.mydataway.demo1.system.domain.Menu;
import com.mydataway.demo1.system.dto.MenuDto;
import com.mydataway.demo1.system.dto.RoleDto;
import com.mydataway.demo1.system.dto.RoleMenuDto;
import com.mydataway.demo1.system.dto.RoleQueryDto;
import com.mydataway.demo1.system.repository.MenuRepository;
import com.mydataway.demo1.system.repository.RoleRepository;
import com.mydataway.demo1.system.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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

    @Override
    public RoleDto findById(Long id) {
        return null;
    }

    @Override
    public List<RoleDto> queryAll(RoleQueryDto roleQueryDto) {
        return null;
    }

    @Override
    public void save(RoleDto roleDto) {

    }

    @Override
    public void update(RoleDto roleDto) {

    }

    @Transactional
    @Override
    public void updateMenu(RoleMenuDto roleMenuDto) {
        for (MenuDto menuDto : roleMenuDto.getMenuDtos()) {
            Menu menu = new Menu();
            BeanUtils.copyProperties(menuDto, menu);
            menuRepository.insert(menu);
        }
    }

    @Override
    public void delete(Set<Long> ids) {
        roleRepository.deleteBatchIds(ids);
    }
}
