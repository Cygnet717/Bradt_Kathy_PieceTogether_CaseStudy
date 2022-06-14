package com.kathybradt.piecetogether.Service;


import com.kathybradt.piecetogether.model.User;

import java.util.Optional;

public interface UserDAO {
    public Optional<User> getUser(Long id);

}