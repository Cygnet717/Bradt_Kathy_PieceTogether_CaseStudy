package com.piecetogether.piecetogether.UserPackage;


import java.util.Optional;

public interface UserDAO {
    public Optional<User> getUser(Long id);

}