package com.piecetogether.piecetogether.PetsPackage;

import java.util.List;

public interface PetsDAO {

    public List<Pets> getUserPets(Long userId);
}
