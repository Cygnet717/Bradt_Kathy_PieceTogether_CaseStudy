package com.piecetogether.piecetogether.Service;

import com.piecetogether.piecetogether.Repository.FamilyRepository;
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
