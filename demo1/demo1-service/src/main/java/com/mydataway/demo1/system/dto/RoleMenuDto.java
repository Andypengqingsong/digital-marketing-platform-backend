package com.mydataway.demo1.system.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭青松
 * @project wxws-frameworkcom.mydataway.demo1.system.dto
 * @company 我行我数
 * @date 2020/2/17 1:18
 * @description 描述当前类的用途
 */
@Data
public class RoleMenuDto {
    List<MenuDto> menuDtos = new ArrayList<>();
}
