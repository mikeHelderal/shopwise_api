package com.shopwise.shopwise_back.repository;

import com.shopwise.shopwise_back.model.StatutRdv;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StatutRdvRepositoryTest {

    @Autowired
    private StatutRdvRepository statutRdvRepository;

    @Test
    void testSaveAndFind() {
        // Given
        StatutRdv statut = new StatutRdv();
        statut.setLibelle("Confirmé");

        // When
        StatutRdv saved = statutRdvRepository.save(statut);
        StatutRdv found = statutRdvRepository.findById(saved.getId()).orElse(null);

        // Then
        assertNotNull(found);
        assertEquals("Confirmé", found.getLibelle());
    }
}