package com.piecetogether.piecetogether.Service;

import com.piecetogether.piecetogether.Repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VacationService {
    private final VacationRepository vacationRepository;

    @Autowired
    public VacationService(VacationRepository vacationRepository){
        this.vacationRepository = vacationRepository;
    }
}