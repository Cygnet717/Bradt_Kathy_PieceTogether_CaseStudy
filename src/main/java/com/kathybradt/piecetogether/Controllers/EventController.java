package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.Service.JobsService;
import com.kathybradt.piecetogether.Service.OtherService;
import com.kathybradt.piecetogether.Service.PetsService;
import com.kathybradt.piecetogether.Service.UserService;
import com.kathybradt.piecetogether.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.security.Principal;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    OtherService otherService;
    @Autowired
    PetsService petsService;
    @Autowired
    JobsService jobsService;
    @Autowired
    UserService userService;

    @PostMapping("/event/other")
    public RedirectView createOtherEvent(@ModelAttribute Other event, Principal principal){
        User currUser = userService.findUserByEmail(principal.getName());
        event.setUser(currUser);
        otherService.save(event);
        return new RedirectView("/user");
    }
    @PostMapping("/event/jobs")
    public RedirectView createJobEvent(@ModelAttribute Jobs event, Principal principal){
        User currUser = userService.findUserByEmail(principal.getName());
        event.setUser(currUser);
        jobsService.save(event);
        return new RedirectView("/user");
    }
    @PostMapping("/event/pets")
    public RedirectView createPetEvent(@ModelAttribute Pets event, Principal principal){
        User currUser = userService.findUserByEmail(principal.getName());
        event.setUser(currUser);
        petsService.save(event);
        return new RedirectView("/user");
    }

    @DeleteMapping("/event")
    @ResponseBody
    public void deleteEvent(@RequestParam String eventType, @RequestParam Long id){
//        System.out.println(eventType );
//        System.out.println(id);

        switch (eventType){
            case "Job":
                Jobs jobEvent = jobsService.get(id);
                jobsService.delete(jobEvent);
                break;
            case "Pets":
                Pets petsEvent = petsService.get(id);
                petsService.delete(petsEvent);
                break;
            default:
                Other otherEvent = otherService.get(id);
                otherService.delete(otherEvent);

        }

        new RedirectView("/user");
    }
}
