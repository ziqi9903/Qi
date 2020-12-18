package com.qi.forum.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/userHome")
    public String userControl(){
        return "user/userHome";
    }

}
