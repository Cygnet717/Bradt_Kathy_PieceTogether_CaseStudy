package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.Repository.OtherRepository;
import com.kathybradt.piecetogether.model.Event;
import com.kathybradt.piecetogether.model.Other;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherService {
    private final OtherRepository otherRepository;

    @Autowired
    public OtherService(OtherRepository otherRepository){
        this.otherRepository = otherRepository;
    }


    public Other get(Long id){return otherRepository.getReferenceById(id);}
    public Other save(Other event) {
        return otherRepository.save(event);
    }
    public void delete(Other otherEvent){
        otherRepository.delete(otherEvent);
    }
}
