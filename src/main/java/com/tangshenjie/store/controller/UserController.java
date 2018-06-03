package com.tangshenjie.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/showRegister.do")
    public String showRegister() {
        System.out.println("执行showRegister方法");
        return "register";
    }

}
