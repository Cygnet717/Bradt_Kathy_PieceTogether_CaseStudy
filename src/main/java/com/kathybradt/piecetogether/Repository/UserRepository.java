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

//    @Query("SELECT v, s, j, o, p, f " +
//            "FROM User u, Vacation v, School s, Jobs j, Other o, Pets p, Family f " +
//            "WHERE u.email = ?1 AND( YEAR(v.startDate) = ?2 or YEAR(s.startDate) = ?2" +
//            "or YEAR(j.startDate) = ?2 " +
//            "or YEAR(o.startDate) = ?2 " +
//            "or YEAR(p.startDate) = ?2 " +
//            "or YEAR(f.startDate) = ?2 )")
//    ArrayList<Object> findEventsByYearStartsWith(String email, Integer startDate);


    @Query("Select j FROM User u, Jobs j WHERE u.email = ?1 AND YEAR(j.startDate) = ?2")
    ArrayList<Jobs> findJobsEventsByYear(String email, Integer startDate);

    @Query("Select o FROM User u, Other o WHERE u.email = ?1 AND YEAR(o.startDate) = ?2")
    ArrayList<Other> findOtherEventsByYear(String email, Integer startDate);

    @Query("Select p FROM User u, Pets p WHERE u.email = ?1 AND YEAR(p.startDate) = ?2")
    ArrayList<Pets> findPetsEventsByYear(String email, Integer startDate);


}
