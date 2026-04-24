package com.shopwise.shopwise_back.controller;

import com.shopwise.shopwise_back.model.RendezVous;
import com.shopwise.shopwise_back.service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rendez-vous")
@CrossOrigin(origins = "*")
public class RendezVousController {
    @Autowired
    private RendezVousService rdvService;

    @GetMapping
    public List<RendezVous> getAll() { return rdvService.listAll(); }

    @PostMapping
    public RendezVous create(@RequestBody RendezVous rdv) { return rdvService.save(rdv); }
}
