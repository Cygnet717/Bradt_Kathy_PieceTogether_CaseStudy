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

        //for loop
        //each year from curryear back to 20 years ago (for sanity sake)
        //get years events, make array, and add to userData
        //userData = [ 2022: [objects in that year], 2021: [objects in that year], ect]
        String year = "2020";

        ArrayList<Event> userData = userService.findSortAllEvents(userEmail);
//
//        ArrayList<Object> userData = new ArrayList<Object>();
//        ArrayList<Jobs> jobsEvents = userService.findJobsEventsByYear(userEmail, Integer.valueOf(year));
//        ArrayList<Other> otherEvents = userService.findOtherEventsByYear(userEmail, Integer.valueOf(year));
//        ArrayList<Pets> petsEvents = userService.findPetsEventsByYear(userEmail, Integer.valueOf(year));
//
//        userData.addAll(jobsEvents);
//        userData.addAll(otherEvents);
//        userData.addAll(petsEvents);
        modelAndView.addObject("events", userData);
//        System.out.println(userData);
        modelAndView.addObject("user", currUser);

        return modelAndView;
    }
}
