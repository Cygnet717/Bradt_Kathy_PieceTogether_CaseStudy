package com.piecetogether.piecetogether.Repository;

import com.piecetogether.piecetogether.model.Pets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetsRepository extends JpaRepository<Pets, Long> {
}
