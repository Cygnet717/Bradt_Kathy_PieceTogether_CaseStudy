package com.piecetogether.piecetogether.Service;

import com.piecetogether.piecetogether.Repository.OtherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherService {
    private final OtherRepository otherRepository;

    @Autowired
    public OtherService(OtherRepository otherRepository){
        this.otherRepository = otherRepository;
    }
}
