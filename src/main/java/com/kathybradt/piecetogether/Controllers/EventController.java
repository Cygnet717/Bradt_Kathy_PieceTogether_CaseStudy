package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.Service.JobsService;
import com.kathybradt.piecetogether.Service.OtherService;
import com.kathybradt.piecetogether.Service.PetsService;
import com.kathybradt.piecetogether.model.Jobs;
import com.kathybradt.piecetogether.model.Other;
import com.kathybradt.piecetogether.model.Pets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class EventController {

    @Autowired
    OtherService otherService;
    @Autowired
    PetsService petsService;
    @Autowired
    JobsService jobsService;

    @PostMapping("/event/other")
    public RedirectView createOtherEvent(@ModelAttribute Other event){
        otherService.save(event);
        return new RedirectView("/user");
    }
    @PostMapping("/event/jobs")
    public RedirectView createJobEvent(@ModelAttribute Jobs event){
        jobsService.save(event);
        return new RedirectView("/user");
    }
    @PostMapping("/event/pets")
    public RedirectView createPetEvent(@ModelAttribute Pets event){
        petsService.save(event);
        return new RedirectView("/user");
    }

    @DeleteMapping("/event")
    @ResponseBody
    public RedirectView deleteEvent(@RequestParam Long id){
        System.out.println("----------------------------------");
        Other otherEvent = otherService.get(id);
        otherService.delete(otherEvent);
        return new RedirectView("/user");
    }
}
