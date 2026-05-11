package com.shopwise.shopwise_back.controller;


import com.shopwise.shopwise_back.dto.DashboardDTO;
import com.shopwise.shopwise_back.service.ClientService;
import com.shopwise.shopwise_back.service.ProduitService;
import com.shopwise.shopwise_back.service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardController {
    @Autowired
    private ClientService clientService;
    @Autowired private RendezVousService rdvService;
    @Autowired private ProduitService produitService;

    @GetMapping("/stats")
    public DashboardDTO getStats() {
        DashboardDTO dto = new DashboardDTO();
        dto.setTotalClients(clientService.countAll());
        dto.setRdvDuJour(rdvService.countTodayRdv());
        dto.setProduitsEnAlerte(produitService.countLowStock());
        return dto;
    }
}
