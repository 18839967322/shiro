package com.liuhui.shiro.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Date 2021/7/7 8:59
 * @Author liuhui
 * @Description
 * @Version
 **/
@Configuration
public class ShiroConfig {

    @Bean
    public Realm getRealm(){
        return new MyRealm();
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        Map<String,String> filterMap = new LinkedHashMap<String,String>();
        filterMap.put("/user/*","authc");
        filterMap.put("/index","anon");

        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("tologin");
        return bean;
    }
}
