package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository){
       this.schoolRepository = schoolRepository;
   }
}
