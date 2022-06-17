package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.Repository.JobsRepository;
import com.kathybradt.piecetogether.model.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsService {
    private final JobsRepository jobsRepository;

    @Autowired
    public JobsService(JobsRepository jobsRepository){
        this.jobsRepository = jobsRepository;
    }

    public Jobs save(Jobs event){
        return jobsRepository.save(event);
    }
}
