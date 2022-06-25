package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.Repository.UserRepository;
import com.kathybradt.piecetogether.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;

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
        return userRepository.findByEmail(email);
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

        HashMap<Integer, List<Event>> userEventsCollectedByYear = new HashMap<>();

        for(Event event: allUserEvents){
            Integer currentEventYear = event.getStartDate().toLocalDate().getYear();
            List<Event> yearList = userEventsCollectedByYear.get(currentEventYear);

            if(yearList == null){
                yearList = new ArrayList<Event>();
                yearList.add(event);
                userEventsCollectedByYear.put(currentEventYear, yearList);
            } else {
                if(!yearList.contains(event)) yearList.add(event);
            }
        }

        return userEventsCollectedByYear;
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
