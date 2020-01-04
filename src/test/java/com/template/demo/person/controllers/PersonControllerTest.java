package com.template.demo.person.controllers;

import com.template.demo.person.models.Person;
import com.template.demo.person.services.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class PersonControllerTest {

    @Mock
    private PersonService mockPersonService;

    private PersonController personControllerUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        personControllerUnderTest = new PersonController(mockPersonService);
    }

    @Test
    void testGetPerson() {
        // Setup

        // Configure PersonService.getPerson(...).
        final Person person = new Person();
        when(mockPersonService.getPerson(0L)).thenReturn(person);

        // Run the test
        final Person result = personControllerUnderTest.getPerson(0L);

        // Verify the results
        verify(mockPersonService).getPerson(0L);
    }

    @Test
    void testUpdatePerson() {
        // Setup
        final Person person = new Person();

        when(mockPersonService.updatePerson(any(Person.class))).thenReturn(0L);

        // Run the test
        final Long result = personControllerUnderTest.updatePerson(person);

        // Verify the results
        verify(mockPersonService).updatePerson(person);
        assertEquals(0L, result);
    }

    @Test
    void testCreatePerson() {
        // Setup
        final Person person = new Person();

        when(mockPersonService.createPerson(any(Person.class))).thenReturn(0L);

        // Run the test
        final Long result = personControllerUnderTest.createPerson(person);

        // Verify the results
        verify(mockPersonService).createPerson(person);
        assertEquals(0L, result);
    }

    @Test
    void testDeletePerson() {
        // Setup

        // Run the test
        personControllerUnderTest.deletePerson(0L);

        // Verify the results
        verify(mockPersonService).deletePerson(0L);
    }
}
