package com.qi.forum.controller.useControl;


import com.qi.forum.dto.UserConDTO;
import com.qi.forum.service.UserConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserControlController {

    @Autowired
    private UserConService userConService;

    @GetMapping("/userCon")
    public String userCon(Model model,
                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                          @RequestParam(name = "size",defaultValue = "11") Integer size) {
        UserConDTO userConDTO = userConService.list(page,size);
        model.addAttribute("userConDTO",userConDTO);
        return "/usercontrol/allUser";
    }

}
