package com.liuhui.shiro.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Date 2021/7/7 11:28
 * @Author liuhui
 * @Description
 * @Version
 **/
@Data
public class User implements Serializable {
    private String username;
    private String password;
    private Integer id;
}
