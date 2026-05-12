package com.shopwise.shopwise_back.repository;

import com.shopwise.shopwise_back.model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

    @Query("SELECT COUNT(r) FROM RendezVous r WHERE CAST(r.dateHeure AS date) = CURRENT_DATE")
    long countTodayRdv();
}
