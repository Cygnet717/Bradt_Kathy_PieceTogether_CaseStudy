package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.Repository.UserRepository;
import com.kathybradt.piecetogether.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDAO{

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //Get current user object
    public User findUserByEmail(String email) {
        User currUser = userRepository.findByEmail(email);
        if(currUser != null) {
            List<Other> otherEvents = currUser.getOtherList();
            List<Jobs> jobsEvents = currUser.getJobsList();
            List<Pets> petsEvents = currUser.getPetsList();

            otherEvents.sort(Comparator.comparing(Other::getDate));
            jobsEvents.sort(Comparator.comparing(Jobs::getDate));
            petsEvents.sort(Comparator.comparing(Pets::getDate));

            currUser.setOtherList(otherEvents);
            currUser.setJobsList(jobsEvents);
            currUser.setPetsList(petsEvents);
        }
        return currUser;
    }

    //Get list of events mapped to the year they occurred
    public HashMap<Integer, List<Event>> findSortAllEvents(User currUser) {

        List<Jobs> allUserJobs = currUser.getJobsList();
        List<Pets> allUserPets = currUser.getPetsList();
        List<Other> allUserOther = currUser.getOtherList();
        ArrayList<Event> allUserEvents = new ArrayList<Event>();
        allUserEvents.addAll(allUserJobs);
        allUserEvents.addAll(allUserPets);
        allUserEvents.addAll(allUserOther);
        //collect all events into a hash map
        HashMap<Integer, List<Event>> userEventsCollectedByYear = new HashMap<>();

        for(Event event: allUserEvents){
            Integer currentEventYear = event.getDate().toLocalDate().getYear();
            List<Event> yearList = userEventsCollectedByYear.get(currentEventYear);

            if(yearList == null){
                yearList = new ArrayList<Event>();
                yearList.add(event);
                userEventsCollectedByYear.put(currentEventYear, yearList);
            } else {
                if(!yearList.contains(event)) yearList.add(event);
            }
        }
        //Sort map by year
        LinkedHashMap<Integer, List<Event>> orderedByYear = userEventsCollectedByYear.entrySet().stream().sorted(Map.Entry.<Integer, List<Event>>comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return orderedByYear;
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    //Save new user information to database
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRole("User");
        return userRepository.save(user);
    }

    //Update active user information
    public void updateUser(Long userId, String firstName, String lastName, String email){
        User currUser = userRepository.getById(userId);
        currUser.setFirstName(firstName);
        currUser.setLastName(lastName);
        currUser.setEmail(email);
        userRepository.save(currUser);
    }

}
