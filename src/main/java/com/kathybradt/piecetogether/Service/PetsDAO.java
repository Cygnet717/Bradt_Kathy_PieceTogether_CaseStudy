package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.model.Pets;

import java.util.List;

public interface PetsDAO {

    public List<Pets> getUserPets(Long userId);
}
