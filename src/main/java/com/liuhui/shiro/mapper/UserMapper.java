package com.liuhui.shiro.mapper;

import com.liuhui.shiro.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserMapper
 * @Date 2021/7/7 11:37
 * @Author liuhui
 * @Description
 * @Version
 **/
@Repository
public interface UserMapper {
 User findUserByName(String username);
}
