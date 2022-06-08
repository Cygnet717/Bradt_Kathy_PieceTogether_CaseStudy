package com.piecetogether.piecetogether.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyModRepository extends JpaRepository<BodyModification, Long> {
}
