package com.piecetogether.piecetogether.Repository;

import com.piecetogether.piecetogether.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

}
