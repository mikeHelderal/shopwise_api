package com.shopwise.shopwise_back.repository;

import com.shopwise.shopwise_back.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;

    @Test
    void testSaveAndFind() {
        Client client = new Client();
        client.setNom("Durand");
        client.setEmail("durand@test.com");

        Client saved = clientRepository.save(client);
        Client found = clientRepository.findById(saved.getId()).orElse(null);


        assertNotNull(found);
        assertEquals("Durand", found.getNom());
    }

    @Test
    void testCount() {
        Client c1 = new Client();
        c1.setNom("Client 1");
        c1.setEmail("test1@shopwise.com");
        clientRepository.save(c1);

        Client c2 = new Client();
        c2.setNom("Client 2");
        c2.setEmail("test2@shopwise.com");
        clientRepository.save(c2);

        assertEquals(2, clientRepository.count());
    }
}
