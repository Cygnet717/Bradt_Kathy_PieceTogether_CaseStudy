package com.kathybradt.piecetogether.Repository;

import com.kathybradt.piecetogether.model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
