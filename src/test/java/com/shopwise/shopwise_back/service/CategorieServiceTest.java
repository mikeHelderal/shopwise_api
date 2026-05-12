package com.shopwise.shopwise_back.service;

import com.shopwise.shopwise_back.model.Categorie;
import com.shopwise.shopwise_back.repository.CategorieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategorieServiceTest {

    @Mock
    private CategorieRepository categorieRepository;

    @InjectMocks
    private CategorieService categorieService;

    @Test
    void testListAll() {
        Categorie c1 = new Categorie();
        c1.setNom("Coiffure");
        Categorie c2 = new Categorie();
        c2.setNom("Esthétique");

        when(categorieRepository.findAll()).thenReturn(Arrays.asList(c1, c2));

        List<Categorie> result = categorieService.listAll();

        assertEquals(2, result.size());
        assertEquals("Coiffure", result.get(0).getNom());
        verify(categorieRepository, times(1)).findAll();
    }

    @Test
    void testSave() {
        Categorie cat = new Categorie();
        cat.setNom("Nouveau");
        when(categorieRepository.save(any(Categorie.class))).thenReturn(cat);

        Categorie saved = categorieService.save(cat);

        assertNotNull(saved);
        assertEquals("Nouveau", saved.getNom());
        verify(categorieRepository, times(1)).save(cat);
    }
}