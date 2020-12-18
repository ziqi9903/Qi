package com.qi.forum.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BolgIndexController {

    @GetMapping("/bolgIndex")
    public String blogIndex(){
        return "/";
    }

}
