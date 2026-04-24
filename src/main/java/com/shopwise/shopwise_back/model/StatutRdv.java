package com.shopwise.shopwise_back.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ref_statuts_rdv")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class StatutRdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private String libelle;
}