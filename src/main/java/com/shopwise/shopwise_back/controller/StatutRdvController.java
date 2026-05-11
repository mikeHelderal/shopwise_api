package com.shopwise.shopwise_back.controller;

import com.shopwise.shopwise_back.model.StatutRdv;
import com.shopwise.shopwise_back.service.StatutRdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/statuts")
public class StatutRdvController {
    @Autowired
    private StatutRdvService statutRdvService;

    @GetMapping
    public List<StatutRdv> getAll() { return statutRdvService.listAll(); }
}
