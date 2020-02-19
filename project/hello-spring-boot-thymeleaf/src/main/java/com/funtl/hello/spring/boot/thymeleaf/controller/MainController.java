package com.funtl.hello.spring.boot.thymeleaf.controller;

import com.funtl.hello.spring.boot.thymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    //约定优于配置,Thymeleaf默认找html为后缀的，并且放到src/main/resources/templates下的
    @RequestMapping(value = {"","index"},method = RequestMethod.GET)
    public String index(Model model){
        User user = new User();
        user.setUsername("Lusifer");
        model.addAttribute("user",user);
        return "index";
    }
}
