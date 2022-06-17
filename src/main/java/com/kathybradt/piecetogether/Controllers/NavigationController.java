package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.Repository.OtherRepository;
import com.kathybradt.piecetogether.Repository.UserRepository;
import com.kathybradt.piecetogether.Service.MyUserDetailService;
import com.kathybradt.piecetogether.Service.OtherService;
import com.kathybradt.piecetogether.Service.UserService;
import com.kathybradt.piecetogether.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.lang.reflect.Array;
import java.rmi.ServerException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class NavigationController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OtherService otherService;

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


    @PostMapping("/event")
    public RedirectView createEvent(@ModelAttribute Other event){
        otherService.save(event);
        return new RedirectView("/user");
    }

    @DeleteMapping("/event")
    @ResponseBody
    public RedirectView deleteEvent(@RequestParam Long id){
        System.out.println("----------------------------------");
        Other otherEvent = otherService.get(id);
        otherService.delete(otherEvent);
        return new RedirectView("/user");
    }

}
