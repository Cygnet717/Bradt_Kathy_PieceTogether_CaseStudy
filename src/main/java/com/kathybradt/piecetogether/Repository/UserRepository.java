package com.kathybradt.piecetogether.Repository;

import com.kathybradt.piecetogether.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Value;

import javax.transaction.Transaction;
import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Query to find user by email
    @Query("SELECT u FROM User u WHERE u.email = ?1")
   User findByEmail(String email);

    //Query to find user by firstName
    @Query("SELECT u FROM User u WHERE u.firstName = ?1")
    User findByFirstName(String firstName);

    //Query to get list of all job events
    @Query("Select j FROM User u, Jobs j WHERE u.email = ?1")
    ArrayList<Jobs> findJobsEvents(String email);

    //Query to get list of all other events
    @Query("Select o FROM User u, Other o WHERE u.email = ?1")
    ArrayList<Other> findOtherEvents(String email);

    //Query to get list of all pet events
    @Query("Select p FROM User u, Pets p WHERE u.email = ?1")
    ArrayList<Pets> findPetsEvents(String email);

}
