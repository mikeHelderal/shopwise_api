package com.shopwise.shopwise_back.controller;
import com.shopwise.shopwise_back.model.Client;
import com.shopwise.shopwise_back.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAll() { return clientService.listAll(); }

    @PostMapping
    public Client create(@RequestBody Client client) { return clientService.save(client); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { clientService.delete(id); }
}
