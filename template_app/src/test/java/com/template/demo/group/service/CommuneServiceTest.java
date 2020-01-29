package com.template.demo.group.service;

import com.template.demo.group.model.Commune;
import com.template.demo.group.repositories.CommuneRepository;
import com.template.demo.person.models.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
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
    private CommuneRepository mockGroupRepository;

    private CommuneService communeServiceUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        communeServiceUnderTest = new CommuneService(mockGroupRepository);
    }

    @Test
    void testGetCommune() {
        // Setup

        // Configure CommuneRepository.findById(...).
        final Optional<Commune> commune = Optional.of(new Commune(0L, "groupName", Arrays.asList(new Person(0L, "firstName", "middleName", "lastName", "gender", LocalDate.of(2017, 1, 1), null))));
        when(mockGroupRepository.findById(0L)).thenReturn(commune);

        // Run the test
        final Commune result = communeServiceUnderTest.getCommune(0L);

        // Verify the results
    }

    @Test
    void testUpdateCommune() {
        // Setup
        final Commune group = new Commune(0L, "groupName", Arrays.asList(new Person(0L, "firstName", "middleName", "lastName", "gender", LocalDate.of(2017, 1, 1), null)));
        when(mockGroupRepository.existsById(0L)).thenReturn(true);

        // Configure CommuneRepository.save(...).
        final Commune commune = new Commune(0L, "groupName", Arrays.asList(new Person(0L, "firstName", "middleName", "lastName", "gender", LocalDate.of(2017, 1, 1), null)));
        when(mockGroupRepository.save(any(Commune.class))).thenReturn(commune);

        // Run the test
        final Long result = communeServiceUnderTest.updateCommune(group);

        // Verify the results
        assertEquals(0L, result);
    }

    @Test
    void testCreateCommune() {
        // Setup
        final Commune group = new Commune(0L, "groupName", Arrays.asList(new Person(0L, "firstName", "middleName", "lastName", "gender", LocalDate.of(2017, 1, 1), null)));
        when(mockGroupRepository.existsById(0L)).thenReturn(false);

        // Configure CommuneRepository.save(...).
        final Commune commune = new Commune(0L, "groupName", Arrays.asList(new Person(0L, "firstName", "middleName", "lastName", "gender", LocalDate.of(2017, 1, 1), null)));
        when(mockGroupRepository.save(any(Commune.class))).thenReturn(commune);

        // Run the test
        final Long result = communeServiceUnderTest.createCommune(group);

        // Verify the results
        assertEquals(0L, result);
    }

    @Test
    void testDeleteCommune() {
        // Setup

        // Run the test
        communeServiceUnderTest.deleteCommune(0L);

        // Verify the results
        verify(mockGroupRepository).deleteById(0L);
    }

    @Test
    void testGetAllCommunes() {
        // Setup

        // Configure CommuneRepository.findAll(...).
        final List<Commune> communes = Arrays.asList(new Commune(0L, "groupName", Arrays.asList(new Person(0L, "firstName", "middleName", "lastName", "gender", LocalDate.of(2017, 1, 1), null))));
        when(mockGroupRepository.findAll()).thenReturn(communes);

        // Run the test
        final List<Commune> result = communeServiceUnderTest.getAllCommunes();

        // Verify the results
    }

    @Test
    void testDeleteAllCommunes() {
        // Setup

        // Run the test
        communeServiceUnderTest.deleteAllCommunes();

        // Verify the results
        verify(mockGroupRepository).deleteAll();
    }
}
