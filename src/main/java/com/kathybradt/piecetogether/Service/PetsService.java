package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.Repository.PetsRepository;
import com.kathybradt.piecetogether.model.Other;
import com.kathybradt.piecetogether.model.Pets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetsService {
    private final PetsRepository petsRepository;

    @Autowired
    public PetsService(PetsRepository petsRepository){
        this.petsRepository = petsRepository;
    }

    public Pets get(Long id){return petsRepository.getReferenceById(id);}

    public Pets save(Pets event){
        return petsRepository.save(event);
    }



    public void delete(Pets petsEvent){
        petsRepository.delete(petsEvent);
    }
}
