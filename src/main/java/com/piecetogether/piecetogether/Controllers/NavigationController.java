package com.piecetogether.piecetogether.Controllers;

import com.piecetogether.piecetogether.model.User;
import com.piecetogether.piecetogether.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NavigationController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping({"/home", "/"})
    public String getHomePage(){
        return "index";
    }

//    @GetMapping("/login")
//    public String getLoginPage(){
//        return "loginPage";
//    }
//
//    @GetMapping("/register")
//    public String getRegisterPage(Model model){
//        model.addAttribute("user", new User());
//        return "registerPage";
//    }

//    @PostMapping("/process_register")
//    public String processRegistration(User user){
//        userRepo.save(user);
//
//        return "bulkAdd";
//    }

    @GetMapping("/user")
    public String getUserPage(){

        return "userPage";
    }

    @GetMapping("/list_users")
    public String viewUsersList(){
        return "listUsers";
    }
}
