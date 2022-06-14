package com.kathybradt.piecetogether.Repository;

import com.kathybradt.piecetogether.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

}
