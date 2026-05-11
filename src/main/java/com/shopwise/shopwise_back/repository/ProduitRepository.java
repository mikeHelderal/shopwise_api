package com.shopwise.shopwise_back.repository;


import com.shopwise.shopwise_back.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @Query("SELECT COUNT(p) FROM Produit p WHERE p.stock <= p.seuilAlerte")
    long countLowStock();
}
