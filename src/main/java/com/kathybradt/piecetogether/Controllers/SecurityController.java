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
    public ArrayList<Object> getCurrentUser(Principal principal){
        String userEmail = principal.getName();
        //User currUser = userService.findUserByEmail(userEmail);
        ArrayList<Object> userData = new ArrayList<Object>();
        ArrayList<Family> familyEvents = userService.findFamilyEventsByYear(userEmail, 2020);
        ArrayList<Jobs> jobsEvents = userService.findJobsEventsByYear(userEmail, 2020);
        ArrayList<Other> otherEvents = userService.findOtherEventsByYear(userEmail, 2020);
        ArrayList<Pets> petsEvents = userService.findPetsEventsByYear(userEmail, 2020);
        ArrayList<School> schoolEvents = userService.findSchoolEventsByYear(userEmail, 2020);
        ArrayList<Vacation> vacationEvents = userService.findVacationEventsByYear(userEmail, 2020);
//        userData.add(currUser);

        userData.addAll(familyEvents);
        userData.addAll(jobsEvents);
        userData.addAll(otherEvents);
        userData.addAll(petsEvents);
        userData.addAll(schoolEvents);
        userData.addAll(vacationEvents);
        return userData;
    }


}
