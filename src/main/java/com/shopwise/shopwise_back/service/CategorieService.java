package com.shopwise.shopwise_back.service;
import com.shopwise.shopwise_back.model.Categorie;
import com.shopwise.shopwise_back.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> listAll() { return categorieRepository.findAll(); }
    public Categorie save(Categorie cat) { return categorieRepository.save(cat); }
}