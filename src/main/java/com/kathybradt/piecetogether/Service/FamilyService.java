package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.Repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {
    private final FamilyRepository familyRepository;

    @Autowired
    public FamilyService(FamilyRepository familyRepository){
        this.familyRepository = familyRepository;
    }
}
