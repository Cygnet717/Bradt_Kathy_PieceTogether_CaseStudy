package com.piecetogether.piecetogether.Service;

import com.piecetogether.piecetogether.model.Family;

import java.util.List;

public interface FamilyDAO {

    public List<Family> getUserFamily(Long userId);
}
