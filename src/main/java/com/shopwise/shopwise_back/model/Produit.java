package com.shopwise.shopwise_back.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produits")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private Double prixUnitaire;
    private Integer seuilAlerte;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}
