package com.kathybradt.piecetogether.Repository;

import com.kathybradt.piecetogether.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
   User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.firstName = ?1")
    User findByFirstName(String firstName);


    @Query("Select j FROM User u, Jobs j WHERE u.email = ?1")
    ArrayList<Jobs> findJobsEvents(String email);

    @Query("Select o FROM User u, Other o WHERE u.email = ?1")
    ArrayList<Other> findOtherEvents(String email);

    @Query("Select p FROM User u, Pets p WHERE u.email = ?1")
    ArrayList<Pets> findPetsEvents(String email);

// AND YEAR(j.startDate) = ?2 ORDER BY j.startDate
}
