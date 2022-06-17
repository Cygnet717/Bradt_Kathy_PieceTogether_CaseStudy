package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.Service.UserService;
import com.kathybradt.piecetogether.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.plaf.metal.MetalLabelUI;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class SecurityController {
    @Autowired
    UserService userService;

//    @RequestMapping(value = "/userdata", method = RequestMethod.GET)
//    @ResponseBody
//    public HashMap<Integer, List<Event>> getCurrentUser(Principal principal){
//        String userEmail = principal.getName();
//        User currUser = userService.findUserByEmail(userEmail);
//
//        List<Jobs> allUserJobs = currUser.getJobsList();
//        List<Pets> allUserPets = currUser.getPetsList();
//        List<Other> allUserOther = currUser.getOtherList();
//        ArrayList<Event> allUserEvents = new ArrayList<Event>();
//        allUserEvents.addAll(allUserJobs);
//        allUserEvents.addAll(allUserPets);
//        allUserEvents.addAll(allUserOther);
//
//        HashMap<Integer, List<Event>> userEventsCollectedByYear = new HashMap<>();
//
//        for(Event event: allUserEvents){
//            Integer currentEventYear = event.getStartDate().toLocalDate().getYear();
//            List<Event> yearList = userEventsCollectedByYear.get(currentEventYear);
//
//            if(yearList == null){
//                yearList = new ArrayList<Event>();
//                yearList.add(event);
//                userEventsCollectedByYear.put(currentEventYear, yearList);
//            } else {
//                if(!yearList.contains(event)) yearList.add(event);
//            }
//        }
//
//        Long userId = currUser.getId();
//        HashMap<Integer, ArrayList<Event>> userData = userService.findSortAllEvents(userEmail, userId);
//
//        return userEventsCollectedByYear;
//    }


}
