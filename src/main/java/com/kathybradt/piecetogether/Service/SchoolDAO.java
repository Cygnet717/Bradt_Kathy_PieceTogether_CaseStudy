package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.model.School;

import java.util.List;

public interface SchoolDAO {

    public List<School> getUserSchool(Long userId);
}
