package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.Service.UserService;
import com.kathybradt.piecetogether.model.Event;
import com.kathybradt.piecetogether.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public ModelAndView getUserPage(Principal principal){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPage");

        String userEmail = principal.getName();
        User currUser = userService.findUserByEmail(userEmail);
        HashMap<Integer, List<Event>> userData = userService.findSortAllEvents(currUser);

        modelAndView.addObject("yearData", userData);
        modelAndView.addObject("user", currUser);

        return modelAndView;
    }



}
