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

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }



    public ArrayList<Jobs> findJobsEvents(String email){ return userRepository.findJobsEvents(email);}

    public ArrayList<Other> findOtherEvents(String email){ return userRepository.findOtherEvents(email);}

    public ArrayList<Pets> findPetsEvents(String email){ return userRepository.findPetsEvents(email);}

    public HashMap<Integer, ArrayList<Event>> findSortAllEvents(String email) {
        ArrayList<Jobs> allJobs = userRepository.findJobsEvents(email);
        ArrayList<Other> allOther = userRepository.findOtherEvents(email);
        ArrayList<Pets> allPets = userRepository.findPetsEvents(email);

        ArrayList<Event> allEventsSorted = new ArrayList<>();
        allEventsSorted.addAll(allOther);
        allEventsSorted.addAll(allJobs);
        allEventsSorted.addAll(allPets);
// sorting dates not necessary any more
//        Comparator<Event> compareByDate = (Event o1, Event o2) -> o1.getStartDate().compareTo(o2.getStartDate());
//        Collections.sort(allEventsSorted, compareByDate.reversed());

        HashMap<Integer, ArrayList<Event>> eventsCollectedByYear = new HashMap<>();

        for(Event event: allEventsSorted){
            Integer currentEventYear = event.getStartDate().toLocalDate().getYear();
            ArrayList<Event> yearList = eventsCollectedByYear.get(currentEventYear);

            if(yearList == null){
                yearList = new ArrayList<Event>();
                yearList.add(event);
                eventsCollectedByYear.put(currentEventYear, yearList);
            } else {
                if(!yearList.contains(event)) yearList.add(event);
            }
        }

        return eventsCollectedByYear;
    }

    public User findUserByUserName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRole("User");
        return userRepository.save(user);
    }



}
