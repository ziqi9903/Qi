package com.qi.forum.controller.Login;

import com.qi.forum.entity.User;
import com.qi.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;
import java.util.UUID;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(){
        return "register/register";
    }

    @PostMapping("/toRegister")
    public String toRegister(@PathParam("username") String username,
                             @PathParam("password") String password,
                             Model model){
        if(username.length() < 4){
            model.addAttribute("msg","请输入长度大于四位的用户名");
            return "register/register";
        }
        if(password.length() < 6){
            model.addAttribute("msg","请输入密码大于六位的用户名");
            return "register/register";
        }
        User user = new User();
        user.setAccount_id(99L);
        user.setUser_name(username);
        user.setUser_password(password);
        user.setToken(UUID.randomUUID().toString());

        userService.InsertUser(user);
        return "login/login";
    }

}
