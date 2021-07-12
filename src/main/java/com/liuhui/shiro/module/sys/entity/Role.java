package com.liuhui.shiro.module.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Role
 * @Date 2021/7/12 20:28
 * @Author liuhui
 * @Description
 * @Version
 **/
@Data
public class Role implements Serializable {

    private Long roleId;
    private Long orgId;
    private String roleName;
    private String roleSign;
    private String remark;
    private Long userIdCreate;
    private Date gmtCreate;
    private Date gmtModified;
}
