package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.Service.JobsService;
import com.kathybradt.piecetogether.Service.OtherService;
import com.kathybradt.piecetogether.Service.PetsService;
import com.kathybradt.piecetogether.Service.UserService;
import com.kathybradt.piecetogether.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.security.Principal;


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

    @PostMapping("/event/other")  //add new other type event to database
    public RedirectView createOtherEvent(@ModelAttribute Other event, Principal principal){
        User currUser = userService.findUserByEmail(principal.getName());
        event.setUser(currUser);
        otherService.save(event);
        return new RedirectView("/user");
    }

    @PostMapping("/event/jobs")  //add new job type event to database
    public RedirectView createJobEvent(@ModelAttribute Jobs event, Principal principal){
        User currUser = userService.findUserByEmail(principal.getName());
        event.setUser(currUser);
        jobsService.save(event);
        return new RedirectView("/user");
    }

    @PostMapping("/event/pets")  //add new pet type event to database
    public RedirectView createPetEvent(@ModelAttribute Pets event, Principal principal){
        User currUser = userService.findUserByEmail(principal.getName());
        event.setUser(currUser);
        petsService.save(event);
        return new RedirectView("/user");
    }

    @GetMapping("/event/Other")  //edit other event already in database
    public RedirectView editOtherEvent(@ModelAttribute Other event, Principal principal){
        User currUser = userService.findUserByEmail(principal.getName());
        event.setUser(currUser);

        otherService.save(event);

        return new RedirectView("/user");
    }

    @GetMapping("/event/Jobs")  //edit job event already in database
    public RedirectView editJobEvent(@ModelAttribute Jobs event, Principal principal){
        User currUser = userService.findUserByEmail(principal.getName());
        event.setUser(currUser);

        jobsService.save(event);

        return new RedirectView("/user");
    }

    @GetMapping("/event/Pets")  //edit pet event already in database
    public RedirectView editPetEvent(@ModelAttribute Pets event, Principal principal){
        User currUser = userService.findUserByEmail(principal.getName());
        event.setUser(currUser);

        petsService.save(event);

        return new RedirectView("/user");
    }

    @DeleteMapping("/event")  //delete event based on type of event
    @ResponseBody
    public void deleteEvent(@RequestParam String eventType, @RequestParam Long id){

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
