package com.kathybradt.piecetogether.Repository;

import com.kathybradt.piecetogether.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs, Long> {
}
