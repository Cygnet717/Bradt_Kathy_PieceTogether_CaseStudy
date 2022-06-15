package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.Repository.UserRepository;
import com.kathybradt.piecetogether.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Optional;

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

    //public ArrayList<Object> findEventsByYear(String email, Integer startDate) { return userRepository.findEventsByYearStartsWith(email, startDate); }
    public ArrayList<Family> findFamilyEventsByYear(String email, Integer startDate ){ return userRepository.findFamilyEventsByYear(email, startDate);}

    public ArrayList<Jobs> findJobsEventsByYear(String email, Integer startDate ){ return userRepository.findJobsEventsByYear(email, startDate);}

    public ArrayList<Other> findOtherEventsByYear(String email, Integer startDate ){ return userRepository.findOtherEventsByYear(email, startDate);}

    public ArrayList<Pets> findPetsEventsByYear(String email, Integer startDate ){ return userRepository.findPetsEventsByYear(email, startDate);}

    public ArrayList<School> findSchoolEventsByYear(String email, Integer startDate ){ return userRepository.findSchoolEventsByYear(email, startDate);}

    public ArrayList<Vacation> findVacationEventsByYear(String email, Integer startDate ){ return userRepository.findVacationEventsByYear(email, startDate);}

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
