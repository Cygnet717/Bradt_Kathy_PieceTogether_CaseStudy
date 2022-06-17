package com.kathybradt.piecetogether.Repository;

import com.kathybradt.piecetogether.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long> {
//    @Query("INSERT User_id, jobsList_eventId INTO user_jobslist VALUES (?1, ?2)")
//    void addJobUserLink(Long userId, Long eventId);
}
