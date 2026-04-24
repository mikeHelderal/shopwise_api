package com.shopwise.shopwise_back.service;


import com.shopwise.shopwise_back.model.Produit;
import com.shopwise.shopwise_back.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> listAll() { return produitRepository.findAll(); }
    public Produit save(Produit p) { return produitRepository.save(p); }
    public void delete(Long id) { produitRepository.deleteById(id); }
}
