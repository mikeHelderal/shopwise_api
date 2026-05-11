package com.shopwise.shopwise_back.controller;

import com.shopwise.shopwise_back.model.RendezVous;
import com.shopwise.shopwise_back.service.RendezVousService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class RendezVousControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private RendezVousService rdvService;

    @Test
    void testGetAllRendezVous() throws Exception {
        // On simule une liste avec 2 rendez-vous
        when(rdvService.listAll()).thenReturn(List.of(new RendezVous(), new RendezVous()));

        mockMvc.perform(get("/api/rendez-vous"))
                .andExpect(status().isOk())
                // On vérifie que c'est un tableau JSON de taille 2
                .andExpect(jsonPath("$.length()").value(2));
    }
}