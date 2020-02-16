package com.mydataway.demo1.system.rest;

import com.mydataway.base.BusinessResponse;
import com.mydataway.base.CommonResponseEnum;
import com.mydataway.demo1.system.domain.Role;
import com.mydataway.demo1.system.dto.RoleDto;
import com.mydataway.demo1.system.dto.RoleQueryDto;
import com.mydataway.demo1.system.service.RoleService;
import com.mydataway.demo1.system.service.UserService;
import com.mydataway.exception.BadRequestException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2018-12-03
 */
@Api(tags = "系统：角色管理")
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;
    private final UserService userService;

    private static final String ENTITY_NAME = "role";

    public RoleController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @ApiOperation("获取单个role")
    @GetMapping(value = "/{id}")
    @PreAuthorize("@el.check('roles:list')")
    public BusinessResponse getRoles(@PathVariable Long id) {
        RoleDto roleDto = roleService.findById(id);
        return new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(), CommonResponseEnum.SUCCESS.getmsg(), roleDto);
    }


    @ApiOperation("返回全部的角色")
    @GetMapping(value = "/all")
    @PreAuthorize("@el.check('roles:list','user:add','user:edit')")
    public BusinessResponse getAll(@PageableDefault(value = 2000, sort = {"level"}, direction = Sort.Direction.ASC) Pageable pageable) {
        roleService.queryAll(pageable)
        return new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(), CommonResponseEnum.SUCCESS.getmsg());
    }

    @ApiOperation("查询角色")
    @GetMapping
    @PreAuthorize("@el.check('roles:list')")
    public BusinessResponse getRoles(RoleQueryDto roleQueryDto) {
//        return new ResponseEntity<>(roleService.queryAll(criteria, pageable), HttpStatus.OK);
        return new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(), CommonResponseEnum.SUCCESS.getmsg());
    }

    @ApiOperation("新增角色")
    @PostMapping
    @PreAuthorize("@el.check('roles:add')")
    public BusinessResponse create(@Validated @RequestBody Role resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
//        getLevels(resources.getLevel());
//        return new ResponseEntity<>(roleService.create(resources), HttpStatus.CREATED);
        return new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(), CommonResponseEnum.SUCCESS.getmsg());
    }

    @ApiOperation("修改角色")
    @PutMapping
    @PreAuthorize("@el.check('roles:edit')")
    public BusinessResponse update(@RequestBody Role resources) {
//        getLevels(resources.getLevel());
        roleService.update(resources);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(), CommonResponseEnum.SUCCESS.getmsg());
    }

    @ApiOperation("修改角色菜单")
    @PutMapping(value = "/menu")
    @PreAuthorize("@el.check('roles:edit')")
    public BusinessResponse updateMenu(@RequestBody Role resources) {
        RoleDto role = roleService.findById(resources.getId());
//        getLevels(role.getLevel());
        roleService.updateMenu(resources, role);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(), CommonResponseEnum.SUCCESS.getmsg());
    }

    @ApiOperation("删除角色")
    @DeleteMapping
    @PreAuthorize("@el.check('roles:del')")
    public BusinessResponse delete(@RequestBody Set<Long> ids) {
        for (Long id : ids) {
            RoleDto role = roleService.findById(id);
//            getLevels(role.getLevel());
        }
        roleService.delete(ids);
//        return new ResponseEntity<>(HttpStatus.OK);
        return new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(), CommonResponseEnum.SUCCESS.getmsg());
    }

//    /**
//     * 获取用户的角色级别
//     *
//     * @return /
//     */
//    private int getLevels(Integer level) {
//        UserDto user = userService.findByName(SecurityUtils.getUsername());
//        List<Integer> levels = roleService.findByUsersId(user.getId()).stream().map(RoleSmallDto::getLevel).collect(Collectors.toList());
//        int min = Collections.min(levels);
//        if (level != null) {
//            if (level < min) {
//                throw new BadRequestException("权限不足，你的角色级别：" + min + "，低于操作的角色级别：" + level);
//            }
//        }
//        return min;
//    }
}
