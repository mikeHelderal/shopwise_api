package com.shopwise.shopwise_back.service;
import com.shopwise.shopwise_back.model.Client;
import com.shopwise.shopwise_back.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    void testCountAll() {
        when(clientRepository.count()).thenReturn(150L);

        long count = clientService.countAll();

        assertEquals(150L, count);
    }

    @Test

    void testSaveClient() {
        Client client = new Client();
        client.setNom("Doe");
        when(clientRepository.save(any(Client.class))).thenReturn(client);

        Client saved = clientService.save(client);

        assertNotNull(saved);
        assertEquals("Doe", saved.getNom());
    }

    @Test
    void testGetById() {
        Client client = new Client();
        client.setId(1L);
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        Optional<Client> result = clientService.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }
}
