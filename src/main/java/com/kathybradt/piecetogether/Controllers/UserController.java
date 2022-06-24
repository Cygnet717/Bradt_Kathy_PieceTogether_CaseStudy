package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.Service.UserService;
import com.kathybradt.piecetogether.model.Event;
import com.kathybradt.piecetogether.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    @GetMapping("/user") //get dashboard (main user page)
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

    @GetMapping("/user/category") //get the category page depending on which category is selected
    public ModelAndView getOtherPage(Principal principal, @RequestParam String type){

        ModelAndView modelAndView = new ModelAndView();
        String userEmail = principal.getName();
        User currUser = userService.findUserByEmail(userEmail);

        switch (type){
            case "Other":
                modelAndView.setViewName("otherEvents");
                modelAndView.addObject("user", currUser);
                modelAndView.addObject("category", "Other");
                break;
            case "Job":
                modelAndView.setViewName("jobsEvents");
                modelAndView.addObject("user", currUser);
                break;
            case "Pet":
                modelAndView.setViewName("petsEvents");
                modelAndView.addObject("user", currUser);
                break;
            case "School":
                modelAndView.setViewName("otherEvents");
                modelAndView.addObject("user", currUser);
                modelAndView.addObject("category", "School");
                break;
            case "Vacation":
                modelAndView.setViewName("otherEvents");
                modelAndView.addObject("user", currUser);
                modelAndView.addObject("category", "Vacation");
                break;
            case "Family":
                modelAndView.setViewName("otherEvents");
                modelAndView.addObject("user", currUser);
                modelAndView.addObject("category", "Family");
                break;
        }

        return modelAndView;
    }

    @GetMapping("/user/settings") //get the settings page
    public ModelAndView getSettingsPage(Principal principal){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("settings");
        String userEmail = principal.getName();
        User currUser = userService.findUserByEmail(userEmail);
        modelAndView.addObject("userCurrent", currUser);

        return modelAndView;
    }

    @PostMapping("/user/update") //Updating user information
    public RedirectView editUser(@RequestParam Long userId, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email){
        userService.updateUser(userId, firstName, lastName, email);
        return new RedirectView("/user/settings");
    }

}
