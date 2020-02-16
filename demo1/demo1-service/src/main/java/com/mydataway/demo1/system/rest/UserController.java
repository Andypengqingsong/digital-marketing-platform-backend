package com.mydataway.demo1.system.rest;

import com.mydataway.base.BusinessResponse;
import com.mydataway.base.CommonResponseEnum;
import com.mydataway.demo1.system.domain.User;
import com.mydataway.demo1.system.dto.UserDto;
import com.mydataway.demo1.system.dto.UserQueryDto;
import com.mydataway.demo1.system.service.RoleService;
import com.mydataway.demo1.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Api(tags = "系统：用户管理")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final RoleService roleService;

    public UserController(PasswordEncoder passwordEncoder, UserService userService, RoleService roleService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.roleService = roleService;
    }


    @ApiOperation("查询用户")
    @GetMapping
//    @PreAuthorize("@el.check('user:list')")
    public BusinessResponse getUsers(UserQueryDto userQueryDto) {
        List<User> users = userService.queryAll(userQueryDto);
        return new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(), CommonResponseEnum.SUCCESS.getmsg(), users);
    }

    @ApiOperation("新增用户")
    @PostMapping
//    @PreAuthorize("@el.check('user:add')")
    public BusinessResponse create(@RequestBody UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode("123456"));
        userService.save(userDto);
        return new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(), CommonResponseEnum.SUCCESS.getmsg());

    }

    @ApiOperation("修改用户")
    @PutMapping
//    @PreAuthorize("@el.check('user:edit')")
    public BusinessResponse update(@RequestBody UserDto userDto) {
        userService.update(userDto);
        return new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(), CommonResponseEnum.SUCCESS.getmsg());
    }


    @ApiOperation("删除用户")
    @DeleteMapping
//    @PreAuthorize("@el.check('user:del')")
    public BusinessResponse delete(@RequestBody Set<Long> ids) {
        userService.delete(ids);
        return new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(), CommonResponseEnum.SUCCESS.getmsg());
    }
//
//
//    /**
//     * 如果当前用户的角色级别低于创建用户的角色级别，则抛出权限不足的错误
//     *
//     * @param resources /
//     */
//    private void checkLevel(UserDto userDto) {
//        UserDto user = userService.findByName(SecurityUtils.getUsername());
//        Integer currentLevel = Collections.min(roleService.findByUsersId(user.getId()).stream().map(RoleSmallDto::getLevel).collect(Collectors.toList()));
//        Integer optLevel = roleService.findByRoles(resources.getRoles());
//        if (currentLevel > optLevel) {
//            throw new BadRequestException("角色权限不足");
//        }
//    }
}
