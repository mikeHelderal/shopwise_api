package com.shopwise.shopwise_back.controller;

import com.shopwise.shopwise_back.service.ClientService;
import com.shopwise.shopwise_back.service.ProduitService;
import com.shopwise.shopwise_back.service.RendezVousService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.CrossOrigin;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@CrossOrigin(origins = "http://localhost:4200")
class DashboardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean // <--- On utilise @MockitoBean au lieu de @MockBean
    private ClientService clientService;

    @MockitoBean
    private ProduitService produitService;

    @MockitoBean
    private RendezVousService rdvService;

    @Test
    void testGetStats() throws Exception {
        when(clientService.countAll()).thenReturn(10L);
        when(rdvService.countTodayRdv()).thenReturn(5L);
        when(produitService.countLowStock()).thenReturn(2L);

        mockMvc.perform(get("/api/dashboard/stats"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalClients").value(10))
                .andExpect(jsonPath("$.rdvDuJour").value(5))
                .andExpect(jsonPath("$.produitsEnAlerte").value(2));
    }
}