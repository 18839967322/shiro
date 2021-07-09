package com.liuhui.shiro.common.config;

import com.liuhui.shiro.module.sys.entity.User;
import com.liuhui.shiro.module.sys.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName MyRealm
 * @Date 2021/7/7 9:08
 * @Author liuhui
 * @Description
 * @Version
 **/
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        User user = userMapper.findUserByName(token.getUsername());
        if(user==null){
            return null;
        }

        return new SimpleAuthenticationInfo("",user.getPassword(),"");
    }
}
