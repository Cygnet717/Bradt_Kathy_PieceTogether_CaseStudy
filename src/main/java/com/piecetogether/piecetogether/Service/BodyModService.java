package com.piecetogether.piecetogether.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodyModService {
    private final BodyModRepository bodyModRepository;

    @Autowired
    public BodyModService(BodyModRepository bodyModRepository){
        this.bodyModRepository = bodyModRepository;
    }
}
