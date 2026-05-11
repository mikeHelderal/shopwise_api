package com.shopwise.shopwise_back.repository;

import com.shopwise.shopwise_back.model.Categorie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CategorieRepositoryTest {

    @Autowired
    private CategorieRepository categorieRepository;

    @Test
    void testSaveAndFindByName() {
        // Given
        Categorie cat = new Categorie();
        cat.setNom("Coiffure");

        // When
        categorieRepository.save(cat);
        Categorie found = categorieRepository.findAll().stream()
                .filter(c -> c.getNom().equals("Coiffure"))
                .findFirst()
                .orElse(null);

        // Then
        assertNotNull(found);
        assertEquals("Coiffure", found.getNom());
    }
}