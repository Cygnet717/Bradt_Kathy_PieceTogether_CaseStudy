package com.piecetogether.piecetogether.VacationPackage;

import org.springframework.beans.factory.annotation.Autowired;

public class VacationService {
    private final VacationRepository vacationRepository;

    @Autowired
    public VacationService(VacationRepository vacationRepository){
        this.vacationRepository = vacationRepository;
    }
}
