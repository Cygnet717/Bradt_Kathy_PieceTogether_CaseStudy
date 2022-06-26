package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.Repository.OtherRepository;
import com.kathybradt.piecetogether.Repository.UserRepository;
import com.kathybradt.piecetogether.Service.*;
import com.kathybradt.piecetogether.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import java.util.Objects;

@Controller
@RequestMapping
public class NavigationController {
    @Autowired
    UserService userService;

    @GetMapping("/login")  //Show login page
    public String login(Model model){
        return "loginPage";
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)  //show registration page
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registerPage");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.POST)  //send new user info to database and send user to login page
    public ModelAndView createNewUser(User user, BindingResult bindingResult) {
        System.out.println("===============================");
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("Email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("login");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("loginPage");

        }
        return modelAndView;
    }



}
