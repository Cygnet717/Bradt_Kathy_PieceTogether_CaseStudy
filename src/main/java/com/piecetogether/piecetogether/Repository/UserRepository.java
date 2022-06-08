package com.piecetogether.piecetogether.Repository;

import com.piecetogether.piecetogether.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
   User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.firstName = ?1")
    User findByFirstName(String firstName);
}
