package com.shopwise.shopwise_back.repository;


import com.shopwise.shopwise_back.model.RendezVous;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RendezVousRepositoryTest {
    @Autowired
    private RendezVousRepository rdvRepository;

    @Test
    void testCountTodayRDV() {
        // Given: Un RDV aujourd'hui et un RDV demain
        RendezVous rdvAujourdhui = new RendezVous();
        rdvAujourdhui.setDateHeure(LocalDateTime.now());
        rdvRepository.save(rdvAujourdhui);

        RendezVous rdvDemain = new RendezVous();
        rdvDemain.setDateHeure(LocalDateTime.now().plusDays(1));
        rdvRepository.save(rdvDemain);

        // When: On compte les RDV du jour
        long count = rdvRepository.countTodayRdv();

        // Then: On doit en trouver exactement 1
        assertEquals(1, count);
    }
}
