package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.Repository.UserRepository;
import com.kathybradt.piecetogether.Service.MyUserDetailService;
import com.kathybradt.piecetogether.Service.UserService;
import com.kathybradt.piecetogether.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class NavigationController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public ModelAndView getUserPage(Principal principal){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPage");

        String userEmail = principal.getName();
        User currUser = userService.findUserByEmail(userEmail);

        HashMap<Integer, ArrayList<Event>> userData = userService.findSortAllEvents(userEmail);

        modelAndView.addObject("yearData", userData);

        modelAndView.addObject("user", currUser);

        return modelAndView;
    }
}
