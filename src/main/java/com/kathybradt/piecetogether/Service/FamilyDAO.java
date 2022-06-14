package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.model.Family;

import java.util.List;

public interface FamilyDAO {

    public List<Family> getUserFamily(Long userId);
}
