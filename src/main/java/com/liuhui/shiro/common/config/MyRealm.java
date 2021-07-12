package com.liuhui.shiro.common.config;

import com.liuhui.shiro.module.sys.entity.Role;
import com.liuhui.shiro.module.sys.entity.User;
import com.liuhui.shiro.module.sys.mapper.UserMapper;
import com.liuhui.shiro.module.sys.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @ClassName MyRealm
 * @Date 2021/7/7 9:08
 * @Author liuhui
 * @Description
 * @Version
 **/
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
       // Set<Role> roles = userService.finRolesByName();
        //info.setRoles();
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        User user = userService.findUserByName(token.getUsername());
        if(user==null){
            return null;
        }

        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
