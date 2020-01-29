package com.template.demo.group.controller;

import com.template.demo.group.model.Commune;
import com.template.demo.group.service.CommuneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class CommuneControllerTest {

    @Mock
    private CommuneService mockCommuneService;

    private CommuneController groupControllerUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        groupControllerUnderTest = new CommuneController(mockCommuneService);
    }

    @Test
    void testGetCommune() {
        // Setup
        when(mockCommuneService.getCommune(0L)).thenReturn(new Commune(0L, "groupName"));

        // Run the test
        final Commune result = groupControllerUnderTest.getCommune(0L);

        // Verify the results
    }

    @Test
    void testUpdateCommune() {
        // Setup
        final Commune group = new Commune(0L, "groupName");
        when(mockCommuneService.updateCommune(any(Commune.class))).thenReturn(0L);

        // Run the test
        final Long result = groupControllerUnderTest.updateCommune(group);

        // Verify the results
        assertEquals(0L, result);
    }

    @Test
    void testCreateCommune() {
        // Setup
        final Commune group = new Commune(0L, "groupName");
        when(mockCommuneService.createCommune(any(Commune.class))).thenReturn(0L);

        // Run the test
        final Long result = groupControllerUnderTest.createCommune(group);

        // Verify the results
        assertEquals(0L, result);
    }

    @Test
    void testDeleteCommune() {
        // Setup

        // Run the test
        groupControllerUnderTest.deleteCommune(0L);

        // Verify the results
        verify(mockCommuneService).deleteCommune(0L);
    }
}
