package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.Repository.JobsRepository;
import com.kathybradt.piecetogether.model.Jobs;
import com.kathybradt.piecetogether.model.Other;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsService {
    private final JobsRepository jobsRepository;

    @Autowired
    public JobsService(JobsRepository jobsRepository){
        this.jobsRepository = jobsRepository;
    }

    public Jobs get(Long id){return jobsRepository.getReferenceById(id);}

    public Jobs save(Jobs event){
        return jobsRepository.save(event);
    }

    public void delete(Jobs jobsEvent){
        jobsRepository.delete(jobsEvent);
    }
}
