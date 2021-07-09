package com.liuhui.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ShiroApplication
 * @Date 2021/7/7 8:49
 * @Author liuhui
 * @Description
 * @Version
 **/
@SpringBootApplication
@MapperScan("com.liuhui.shiro")
public class ShiroApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class,args);
    }

    @RequestMapping(value = {"/","/index"})
    public String index(Model model){
        model.addAttribute("msg","hello-shiro");
        return "index";
    }
}
