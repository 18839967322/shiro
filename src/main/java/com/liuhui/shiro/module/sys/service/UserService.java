package com.liuhui.shiro.module.sys.service;

import com.liuhui.shiro.module.sys.entity.User;

/**
 * @ClassName UserService
 * @Date 2021/7/7 11:26
 * @Author liuhui
 * @Description
 * @Version
 **/
public interface UserService {
    User findUserByName(String username);
}
