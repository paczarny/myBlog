package com.github.paczarny.myblog.controller;

import com.github.paczarny.myblog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping("/login/error")
    public String loginError(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("message", "Wrong username or password. Try again");
        return "login";
    }


}
