package com.shopwise.shopwise_back.controller;

import com.shopwise.shopwise_back.model.Categorie;
import com.shopwise.shopwise_back.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public List<Categorie> getAll() { return categorieService.listAll(); }
}
