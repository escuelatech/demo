package com.demo.helloworld.spring.controllers;

import com.demo.helloworld.spring.jpa.models.User;
import com.demo.helloworld.spring.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class DemoController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/create")
    public String createUser(@RequestBody User user){
        userRepository.save(user);
        return "User Saved Sucessfully";
    }


    @GetMapping("/fetchall")
    public @ResponseBody List<User> getUser(){
        return userRepository.findAll();
    }

}
