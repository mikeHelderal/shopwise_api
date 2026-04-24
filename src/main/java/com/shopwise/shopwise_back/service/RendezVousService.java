package com.shopwise.shopwise_back.service;

import com.shopwise.shopwise_back.model.RendezVous;
import com.shopwise.shopwise_back.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RendezVousService {
    @Autowired
    private RendezVousRepository rdvRepository;

    public List<RendezVous> listAll() { return rdvRepository.findAll(); }
    public RendezVous save(RendezVous rdv) { return rdvRepository.save(rdv); }
    public void cancel(Long id) { rdvRepository.deleteById(id); }
}
