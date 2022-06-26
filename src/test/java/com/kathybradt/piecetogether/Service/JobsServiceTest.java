package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.Repository.JobsRepository;
import com.kathybradt.piecetogether.Repository.UserRepository;
import com.kathybradt.piecetogether.model.Jobs;
import com.kathybradt.piecetogether.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class JobsServiceTest {
    @Autowired
    JobsRepository jobsRepository;
    JobsService jobsService = new JobsService(jobsRepository);

    @Autowired
    UserRepository userRepository;



    @Test
    void get() {
    }

    @Test
    void save() {
        Jobs testJob = new Jobs();
        User testUser = new User();
        testUser.setFirstName("TestFirstName");
        testUser.setLastName("testLastName");
        testUser.setEmail("test@email.com");
        testUser.setPassword("password");
        userRepository.save(testUser);

        testJob.setTitle("testTitle");
        testJob.setDate(Date.valueOf("2020-04-04"));
        testJob.setNotes("Test notes");
        testJob.setCompany("Test Company");
        testJob.setSalary(666);
        testJob.setUser(testUser);

        Jobs savedJob = jobsService.save(testJob);

        assertEquals(testJob, savedJob);

    }

    @Test
    void delete() {
    }
}