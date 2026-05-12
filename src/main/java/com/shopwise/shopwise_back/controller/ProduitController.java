package com.shopwise.shopwise_back.controller;

import com.shopwise.shopwise_back.model.Produit;
import com.shopwise.shopwise_back.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @GetMapping
    public List<Produit> getAll() { return produitService.listAll(); }

    @PostMapping
    public Produit create(@RequestBody Produit produit) { return produitService.save(produit); }
}
