package com.shopwise.shopwise_back.service;

import com.shopwise.shopwise_back.model.StatutRdv;
import com.shopwise.shopwise_back.repository.StatutRdvRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StatutRdvServiceTest {

    @Mock
    private StatutRdvRepository statutRdvRepository;

    @InjectMocks
    private StatutRdvService statutRdvService;

    @Test
    void testListAll() {
        StatutRdv s1 = new StatutRdv();
        s1.setLibelle("En attente");
        StatutRdv s2 = new StatutRdv();
        s2.setLibelle("Terminé");

        when(statutRdvRepository.findAll()).thenReturn(Arrays.asList(s1, s2));

        List<StatutRdv> result = statutRdvService.listAll();

        assertEquals(2, result.size());
        verify(statutRdvRepository, times(1)).findAll();
    }
}