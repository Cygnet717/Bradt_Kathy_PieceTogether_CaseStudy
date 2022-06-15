package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.Service.UserService;
import com.kathybradt.piecetogether.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class SecurityController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/userdata", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Event> getCurrentUser(Principal principal){
        String userEmail = principal.getName();
        //User currUser = userService.findUserByEmail(userEmail);
        ArrayList<Event> userData = new ArrayList<Event>();
        ArrayList<Jobs> jobsEvents = userService.findJobsEvents(userEmail);
        ArrayList<Other> otherEvents = userService.findOtherEvents(userEmail);
        ArrayList<Pets> petsEvents = userService.findPetsEvents(userEmail);
//        userData.add(currUser);

        userData.addAll(jobsEvents);
        userData.addAll(otherEvents);
        userData.addAll(petsEvents);
        return userData;
    }


}
