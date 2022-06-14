package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.Repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetsService {
    private final PetsRepository petsRepository;

    @Autowired
    public PetsService(PetsRepository petsRepository){
        this.petsRepository = petsRepository;
    }
}
