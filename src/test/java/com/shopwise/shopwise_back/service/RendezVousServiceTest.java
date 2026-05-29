package com.shopwise.shopwise_back.service;
import com.shopwise.shopwise_back.model.Client;
import com.shopwise.shopwise_back.model.RendezVous;
import com.shopwise.shopwise_back.repository.RendezVousRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

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

    @Test
    void testHonorerRdv() {
        Client client = new Client();
        client.setPointsFidelite(50);

        RendezVous rdv = new RendezVous();
        rdv.setId(1L);
        rdv.setClient(client);

        when(rdvRepository.findById(1L)).thenReturn(Optional.of(rdv));
        when(rdvRepository.save(any(RendezVous.class))).thenReturn(rdv);

        RendezVous result = rdvService.honorerRdv(1L);

        assertEquals(60, result.getClient().getPointsFidelite());
        verify(rdvRepository, times(1)).save(rdv);
    }
}
