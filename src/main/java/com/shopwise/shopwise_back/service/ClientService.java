package com.shopwise.shopwise_back.service;

import com.shopwise.shopwise_back.model.Client;
import com.shopwise.shopwise_back.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Récupérer tous les clients
    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    // Sauvegarder ou mettre à jour un client
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    // Trouver un client par son ID
    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }

    // Supprimer un client
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
