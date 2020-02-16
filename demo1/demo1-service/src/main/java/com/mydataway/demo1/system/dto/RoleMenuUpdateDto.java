package com.mydataway.demo1.system.dto;

import com.mydataway.demo1.system.domain.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭青松
 * @project wxws-frameworkcom.mydataway.demo1.system.dto
 * @company 我行我数
 * @date 2020/2/17 2:38
 * @description 描述当前类的用途
 */
public class RoleMenuUpdateDto {
    List<MenuDto> menuDtos = new ArrayList<>();

    public List<MenuDto> getMenuDtos() {
        return menuDtos;
    }

    public void setMenuDtos(List<MenuDto> menuDtos) {
        this.menuDtos = menuDtos;
    }
}
