package com.kathybradt.piecetogether.Repository;

import com.kathybradt.piecetogether.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
//    @Query("SELECT s FROM School s WHERE s.startDate LIKE ?1%")
//    List<School> findEventsByYearStartsWith(String startDate);
}
