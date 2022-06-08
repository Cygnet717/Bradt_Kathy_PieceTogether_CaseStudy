package com.piecetogether.piecetogether.Repository;

import com.piecetogether.piecetogether.model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
