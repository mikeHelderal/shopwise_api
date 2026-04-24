package com.shopwise.shopwise_back.repository;

import com.shopwise.shopwise_back.model.StatutRdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutRdvRepository extends JpaRepository<StatutRdv, Long> {
}
