package com.qi.forum.controller.Login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;

@Controller
public class LoginController {

    @GetMapping("/toLogin")
    public String toLogin(){
        return "login/login";
    }

    @GetMapping("/login")
    public String toLogin(@PathParam("username") String username,
                        @PathParam("password") String password,
                        Model model) {
            return "login/login";
    }

    @PostMapping("/login")
    public String login(@PathParam("username") String username,
                        @PathParam("password") String password,
                        Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();

        //封装当前用户
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        //执行登录方法
        try{
            subject.login(token);
            return "index";
        }catch(UnknownAccountException e){
            if(token.getUsername().equals("") || token.getUsername() == null){
                model.addAttribute("msg","用户名不能为空");
                return "login/login";
            }
            model.addAttribute("msg","用户名错误");
            return "login/login";
        }catch (IncorrectCredentialsException e){
            if(token.getPassword().length == 0 || token.getPassword() == null){
                model.addAttribute("msg","密码不能为空");
                return "login/login";
            }
            model.addAttribute("msg","密码错误");
            return "login/login";
        }

    }

    @GetMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login/login";
    }

}
