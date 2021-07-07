package com.liuhui.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ShiroApplication
 * @Date 2021/7/7 8:49
 * @Author liuhui
 * @Description
 * @Version
 **/
@SpringBootApplication
@MapperScan("com.liuhui.shiro.mapper")
public class ShiroApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class,args);
    }
}
