package com.piecetogether.piecetogether.Service;

import com.piecetogether.piecetogether.model.School;

import java.util.List;

public interface SchoolDAO {

    public List<School> getUserSchool(Long userId);
}
