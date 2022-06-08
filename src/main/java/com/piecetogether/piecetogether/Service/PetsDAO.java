package com.piecetogether.piecetogether.Service;

import com.piecetogether.piecetogether.model.Pets;

import java.util.List;

public interface PetsDAO {

    public List<Pets> getUserPets(Long userId);
}
