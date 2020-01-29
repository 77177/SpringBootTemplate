package com.template.demo.group.controller;

import com.template.demo.group.model.Commune;
import com.template.demo.group.service.CommuneService;
import com.template.demo.person.models.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class CommuneControllerTest {

    @Mock
    private CommuneService mockGroupService;

    private CommuneController communeControllerUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        communeControllerUnderTest = new CommuneController(mockGroupService);
    }

    @Test
    void testGetCommune() {
        // Setup

        // Configure CommuneService.getCommune(...).
        final Commune commune = new Commune(0L, "groupName", Arrays.asList(new Person(0L, "firstName", "middleName", "lastName", "gender", LocalDate.of(2017, 1, 1), null)));
        when(mockGroupService.getCommune(0L)).thenReturn(commune);

        // Run the test
        final Commune result = communeControllerUnderTest.getCommune(0L);

        // Verify the results
    }

    @Test
    void testUpdateCommune() {
        // Setup
        final Commune group = new Commune(0L, "groupName", Arrays.asList(new Person(0L, "firstName", "middleName", "lastName", "gender", LocalDate.of(2017, 1, 1), null)));
        when(mockGroupService.updateCommune(any(Commune.class))).thenReturn(0L);

        // Run the test
        final Long result = communeControllerUnderTest.updateCommune(group);

        // Verify the results
        assertEquals(0L, result);
    }

    @Test
    void testCreateCommune() {
        // Setup
        final Commune group = new Commune(0L, "groupName", Arrays.asList(new Person(0L, "firstName", "middleName", "lastName", "gender", LocalDate.of(2017, 1, 1), null)));
        when(mockGroupService.createCommune(any(Commune.class))).thenReturn(0L);

        // Run the test
        final Long result = communeControllerUnderTest.createCommune(group);

        // Verify the results
        assertEquals(0L, result);
    }

    @Test
    void testDeleteCommune() {
        // Setup

        // Run the test
        communeControllerUnderTest.deleteCommune(0L);

        // Verify the results
        verify(mockGroupService).deleteCommune(0L);
    }
}
