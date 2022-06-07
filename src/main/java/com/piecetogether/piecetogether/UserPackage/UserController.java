package com.piecetogether.piecetogether.UserPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    //@GetMapping
    public List<User> getUser(){
        return userService.getUser();
    }

    @GetMapping
    public String hello(){
        return "hello world";
    }
}
