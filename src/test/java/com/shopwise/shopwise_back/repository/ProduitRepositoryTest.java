package com.shopwise.shopwise_back.repository;


import com.shopwise.shopwise_back.model.Produit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ProduitRepositoryTest {

    @Autowired
    private ProduitRepository produitRepository;

    @Test
    void testCountLowStock(){
        Produit p1 = new Produit();
        p1.setNom("Produit OK");
        p1.setStock(10);
        p1.setSeuilAlerte(5);
        produitRepository.save(p1);

        Produit p2 = new Produit();
        p2.setNom("Produit en Alerte");
        p2.setStock(2);
        p2.setSeuilAlerte(5);
        produitRepository.save(p2);
        long alertes = produitRepository.countLowStock();
        assertEquals(1, alertes);
    }
}
