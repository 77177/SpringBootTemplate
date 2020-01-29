package com.template.demo.group.service;

import com.template.demo.group.model.Commune;
import com.template.demo.group.repositories.CommuneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class CommuneServiceTest {

    @Mock
    private CommuneRepository mockCommuneRepository;

    private CommuneService groupServiceUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        groupServiceUnderTest = new CommuneService(mockCommuneRepository);
    }

    @Test
    void testGetCommune() {
        // Setup
        when(mockCommuneRepository.findById(0L)).thenReturn(Optional.of(new Commune(0L, "groupName")));

        // Run the test
        final Commune result = groupServiceUnderTest.getCommune(0L);

        // Verify the results
    }

    @Test
    void testUpdateCommune() {
        // Setup
        final Commune group = new Commune(0L, "groupName");
        when(mockCommuneRepository.existsById(0L)).thenReturn(true);
        when(mockCommuneRepository.save(any(Commune.class))).thenReturn(new Commune(0L, "groupName"));

        // Run the test
        final Long result = groupServiceUnderTest.updateCommune(group);

        // Verify the results
        assertEquals(0L, result);
    }

    @Test
    void testCreateCommune() {
        // Setup
        final Commune group = new Commune(0L, "groupName");
        when(mockCommuneRepository.existsById(0L)).thenReturn(false);
        when(mockCommuneRepository.save(any(Commune.class))).thenReturn(new Commune(0L, "groupName"));

        // Run the test
        final Long result = groupServiceUnderTest.createCommune(group);

        // Verify the results
        assertEquals(0L, result);
    }

    @Test
    void testDeleteCommune() {
        // Setup

        // Run the test
        groupServiceUnderTest.deleteCommune(0L);

        // Verify the results
        verify(mockCommuneRepository).deleteById(0L);
    }

    @Test
    void testGetAllCommunes() {
        // Setup

        // Configure CommuneRepository.findAll(...).
        final List<Commune> groups = Arrays.asList(new Commune(0L, "groupName"));
        when(mockCommuneRepository.findAll()).thenReturn(groups);

        // Run the test
        final List<Commune> result = groupServiceUnderTest.getAllCommunes();

        // Verify the results
    }

    @Test
    void testDeleteAllCommunes() {
        // Setup

        // Run the test
        groupServiceUnderTest.deleteAllCommunes();

        // Verify the results
        verify(mockCommuneRepository).deleteAll();
    }
}
