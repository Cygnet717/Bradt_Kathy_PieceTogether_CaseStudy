package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.Service.JobsService;
import com.kathybradt.piecetogether.Service.OtherService;
import com.kathybradt.piecetogether.Service.PetsService;
import com.kathybradt.piecetogether.Service.UserService;
import com.kathybradt.piecetogether.model.Jobs;
import com.kathybradt.piecetogether.model.Other;
import com.kathybradt.piecetogether.model.Pets;
import com.kathybradt.piecetogether.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@RestController
public class BulkAddController {

    @Autowired
    OtherService otherService;
    @Autowired
    PetsService petsService;
    @Autowired
    JobsService jobsService;
    @Autowired
    UserService userService;

    @PostMapping("/bulkevent/other")
    public RedirectView createOtherEvent(@ModelAttribute Other event, Principal principal){
        User currUser = userService.findUserByEmail(principal.getName());
        event.setUser(currUser);
        otherService.save(event);
        return new RedirectView("/user");
    }
    @PostMapping("/bulkevent/jobs")
    public RedirectView createJobEvent(@ModelAttribute Jobs event, Principal principal){
        User currUser = userService.findUserByEmail(principal.getName());
        event.setUser(currUser);
        jobsService.save(event);
        return new RedirectView("/user");
    }
    @PostMapping("/bulkevent/pets")
    public RedirectView createPetEvent(@ModelAttribute Pets event, Principal principal){
        User currUser = userService.findUserByEmail(principal.getName());
        event.setUser(currUser);
        petsService.save(event);
        return new RedirectView("/user");
    }
}
