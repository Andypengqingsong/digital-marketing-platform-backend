package com.mydataway.demo1.system.rest;

import com.mydataway.demo1.system.domain.User;
import com.mydataway.demo1.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author calvinkun
 * @date 2020/2/15 0015 15:55
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/index")
    public String index(){
        User user = userRepository.selectById(1);
        return "index.......";
    }
}
