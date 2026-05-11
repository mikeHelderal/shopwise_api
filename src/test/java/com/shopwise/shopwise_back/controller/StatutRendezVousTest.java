package com.shopwise.shopwise_back.controller;


import com.shopwise.shopwise_back.service.StatutRdvService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    @SpringBootTest
    @AutoConfigureMockMvc
    class StatutRendezVousTest {
        @Autowired
        private MockMvc mockMvc;
        @MockitoBean
        private StatutRdvService statutService;

        @Test
        void testListAll() throws Exception {
            mockMvc.perform(get("/api/statuts"))
                    .andExpect(status().isOk());
        }
    }

