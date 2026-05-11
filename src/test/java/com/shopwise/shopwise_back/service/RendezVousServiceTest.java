package com.shopwise.shopwise_back.service;
import com.shopwise.shopwise_back.repository.RendezVousRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class RendezVousServiceTest {
    @Mock
    private RendezVousRepository rdvRepository;

    @InjectMocks
    private RendezVousService rdvService;

    @Test
    void testCountTodayRDV() {
        when(rdvRepository.countTodayRdv()).thenReturn(3L);

        long result = rdvService.countTodayRdv();

        assertEquals(3L, result);
    }
}
