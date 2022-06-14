package com.kathybradt.piecetogether.Repository;

import com.kathybradt.piecetogether.model.Other;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherRepository extends JpaRepository<Other, Long> {
}
