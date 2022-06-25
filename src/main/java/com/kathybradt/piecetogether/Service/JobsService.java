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

    //Get single job information
    public Jobs get(Long id){return jobsRepository.getReferenceById(id);}

    //Save new job to database
    public Jobs save(Jobs event){
        return jobsRepository.save(event);
    }

    //Delete job from database
    public void delete(Jobs jobsEvent){
        jobsRepository.delete(jobsEvent);
    }
}
