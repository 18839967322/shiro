package com.liuhui.shiro.module.sys.controller;

import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName IndexController
 * @Date 2021/7/7 8:48
 * @Author liuhui
 * @Description
 * @Version
 **/
@Slf4j
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Producer producer;

    @RequestMapping(value = "/tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping()
    public String login(String username,String password,Model model,String verCode){
        redisTemplate.opsForValue().get(verCode);
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

    @RequestMapping(value = "/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String text = producer.createText();
        log.debug("text:{}",text);
        redisTemplate.opsForValue().set(text,text,60, TimeUnit.SECONDS);
        BufferedImage image = producer.createImage(text);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image,"jpg",outputStream);
        IOUtils.closeQuietly(outputStream);
    }
}
