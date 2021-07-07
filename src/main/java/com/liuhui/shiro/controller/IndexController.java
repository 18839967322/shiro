package com.liuhui.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Date 2021/7/7 8:48
 * @Author liuhui
 * @Description
 * @Version
 **/
@Controller
public class IndexController {

    @RequestMapping(value = {"/","/index"})
    public String index(Model model){
        model.addAttribute("msg","hello-shiro");
        return "index";
    }
    @RequestMapping(value = "/tologin")
    public String tologin(){
        return "login";
    }
    @RequestMapping(value = "/login")
    public String login(String username,String password,Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);
            return "index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码不正确");
        }
        return "login";
    }
}
