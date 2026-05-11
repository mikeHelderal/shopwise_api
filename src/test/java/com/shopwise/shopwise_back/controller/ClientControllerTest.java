package com.shopwise.shopwise_back.controller;

import com.shopwise.shopwise_back.model.Client;
import com.shopwise.shopwise_back.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ClientService clientService;

    @Test
    void testGetAllClients() throws Exception {
        Client c = new Client();
        c.setNom("Alice");
        when(clientService.countAll()).thenReturn(1L); // Exemple simple

        mockMvc.perform(get("/api/clients"))
                .andExpect(status().isOk());
    }
}