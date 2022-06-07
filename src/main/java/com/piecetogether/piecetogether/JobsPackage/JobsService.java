package com.piecetogether.piecetogether.JobsPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsService {
    private final JobsRepository jobsRepository;

    @Autowired
    public JobsService(JobsRepository jobsRepository){
        this.jobsRepository = jobsRepository;
    }
}
