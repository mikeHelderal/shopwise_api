package com.shopwise.shopwise_back.service;

import com.shopwise.shopwise_back.model.Client;
import com.shopwise.shopwise_back.model.RendezVous;
import com.shopwise.shopwise_back.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RendezVousService {
    @Autowired
    private RendezVousRepository rdvRepository;

    public List<RendezVous> listAll() { return rdvRepository.findAll(); }
    public RendezVous save(RendezVous rdv) { return rdvRepository.save(rdv); }
    public void cancel(Long id) { rdvRepository.deleteById(id); }

    @Transactional
    public RendezVous honorerRdv(Long rdvId){
        RendezVous rdv = rdvRepository.findById(rdvId)
                .orElseThrow(() -> new RuntimeException("Rendez-vous introuvable"));

        Client client = rdv.getClient();
        int pointsActuels = client.getPointsFidelite() != null ? client.getPointsFidelite() : 0 ;
        client.setPointsFidelite(pointsActuels + 10);

        return rdvRepository.save(rdv);
    }

    public long countTodayRdv(){
        return rdvRepository.countTodayRdv();
    }
}
