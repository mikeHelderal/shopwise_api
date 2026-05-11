package com.shopwise.shopwise_back.service;

import com.shopwise.shopwise_back.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProduitServiceTest {
    @Mock
    private ProduitRepository produitRepository;

    @InjectMocks
    private ProduitService produitService;

    @Test
    void testCountLowStock() {
        when(produitRepository.countLowStock()).thenReturn(5L);

        long result = produitService.countLowStock();

        assertEquals(5L, result);
        verify(produitRepository, times(1)).countLowStock();
    }
}
