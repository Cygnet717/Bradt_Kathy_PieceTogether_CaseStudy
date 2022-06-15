package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.Service.UserService;
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


@Controller
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

//    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
//    public ModelAndView login(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("loginPage"); // change back to login.......
//
//        return modelAndView;
//    }

    @GetMapping("/login")
    public String login(Model model){
        return "loginPage";
    }

//    @RequestMapping(value = {"/process_login"}, method = RequestMethod.POST)
//    public String processUserLogin(HttpServletRequest request, User user){
//        System.out.println("processing login please!!!!!!!");
//        String userEmail = user.getEmail();
//        String userPassword = user.getPassword();
//        System.out.println(userEmail);
//        authWithHttpServletRequest(request, userEmail, userPassword);
//        return "userPage";
//    }

//    private void authWithHttpServletRequest(HttpServletRequest request, String userEmail, String userPassword) {
//        try{
//            request.login(userEmail, userPassword);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
//    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registerPage");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(User user, BindingResult bindingResult) {
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