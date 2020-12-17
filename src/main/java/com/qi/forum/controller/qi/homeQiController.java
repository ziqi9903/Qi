package com.qi.forum.controller.qi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeQiController {

    @GetMapping("/qi")
    public String home(){
        return "qiStudy/javaShedule";
    }
}
