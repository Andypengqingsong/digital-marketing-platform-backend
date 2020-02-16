package com.mydataway.demo1.system.service.impl;

import com.mydataway.demo1.system.domain.User;
import com.mydataway.demo1.system.dto.UserDto;
import com.mydataway.demo1.system.dto.UserQueryDto;
import com.mydataway.demo1.system.repository.UserRepository;
import com.mydataway.demo1.system.service.UserService;
import com.mydataway.exception.EntityExistException;
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
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> queryAll(UserQueryDto userQueryDto) {
        return userRepository.queryAll();
    }

    @Transactional
    @Override
    public void save(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            throw new EntityExistException(User.class, "username", userDto.getUsername());
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userRepository.insert(user);
    }



    @Transactional
    @Override
    public void update(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userRepository.updateById(user);
    }

    @Transactional
    @Override
    public void delete(Set<Long> ids) {
        userRepository.deleteBatchIds(ids);
    }

    @Override
    public User queryByName(String name) {
        return userRepository.findByUsername(name);
    }
}
