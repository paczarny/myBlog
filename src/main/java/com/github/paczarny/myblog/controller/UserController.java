package com.github.paczarny.myblog.controller;

import com.github.paczarny.myblog.model.User;
import com.github.paczarny.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

@Controller
public class UserController{

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/allUsers")
    @ResponseBody
    public String getAll(){
        Optional<User> user = userRepository.findById(1L);
        if(user.isPresent())
            return user.get().getUsername();
        else
            return "nie ma";
    }
}
