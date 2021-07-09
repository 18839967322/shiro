package com.liuhui.shiro.module.sys.service.impl;

import com.liuhui.shiro.module.sys.entity.User;
import com.liuhui.shiro.module.sys.mapper.UserMapper;
import com.liuhui.shiro.module.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Date 2021/7/7 11:35
 * @Author liuhui
 * @Description
 * @Version
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }
}
