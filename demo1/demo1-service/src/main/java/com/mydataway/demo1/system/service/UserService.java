package com.mydataway.demo1.system.service;

import com.mydataway.demo1.system.domain.User;
import com.mydataway.demo1.system.dto.UserDto;
import com.mydataway.demo1.system.dto.UserQueryDto;

import java.util.List;
import java.util.Set;

public interface UserService {


    List<User> queryAll(UserQueryDto userQueryDto);

    void save(UserDto userDto);


    void update(UserDto userDto);

    void delete(Set<Long> ids);

    User queryByName(String name);
}
