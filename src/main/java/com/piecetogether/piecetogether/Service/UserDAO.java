package com.piecetogether.piecetogether.Service;


import com.piecetogether.piecetogether.model.User;

import java.util.Optional;

public interface UserDAO {
    public Optional<User> getUser(Long id);

}