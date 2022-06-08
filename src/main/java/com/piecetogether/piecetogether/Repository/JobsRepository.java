package com.piecetogether.piecetogether.Repository;

import com.piecetogether.piecetogether.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs, Long> {
}
