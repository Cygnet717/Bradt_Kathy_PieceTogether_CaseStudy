package com.kathybradt.piecetogether.Repository;

import com.kathybradt.piecetogether.model.Pets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetsRepository extends JpaRepository<Pets, Long> {
}
