package com.shopwise.shopwise_back.service;

import com.shopwise.shopwise_back.model.StatutRdv;
import com.shopwise.shopwise_back.repository.StatutRdvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatutRdvService {
    @Autowired
    private StatutRdvRepository statutRdvRepository;

    public List<StatutRdv> listAll() { return statutRdvRepository.findAll(); }
    public StatutRdv save(StatutRdv s) { return statutRdvRepository.save(s); }
}
