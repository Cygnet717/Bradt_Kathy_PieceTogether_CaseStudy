package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.Service.MyUserDetailService;
import com.kathybradt.piecetogether.Service.UserService;
import com.kathybradt.piecetogether.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class NavigationController {
    @Autowired
    UserService userService;
    @GetMapping("/user")
    public ModelAndView getUserPage(Principal principal){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPage");

        return modelAndView;
    }
}
