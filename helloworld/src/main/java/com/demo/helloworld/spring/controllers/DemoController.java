package com.demo.helloworld.spring.controllers;

import com.demo.helloworld.spring.jpa.models.User;
import com.demo.helloworld.spring.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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

       // userRepository.findAll();



        Pageable pageable = PageRequest.of(0, 5);
        Page<User> users = userRepository.findAll(pageable);
        System.out.println("********************************************************");
        System.out.println("Users received = "+users.getSize());
        System.out.println("Total Pages    = "+users.getTotalPages());
        System.out.println("********************************************************");

        for(User user:users){
            System.out.println(user.getFirstName());
        }
        return Collections.emptyList();
    }

}
