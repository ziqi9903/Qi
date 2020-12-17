package com.qi.forum.controller.homepage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    static Logger logger=Logger.getLogger(IndexController.class);

    @GetMapping("/index")
    public String toIndex(){
        logger.info("首页浏览");
        return "index";
    }

}
