package com.template.demo.person.controllers;

import com.template.demo.group.model.Commune;
import com.template.demo.person.models.Person;
import com.template.demo.person.services.PersonService;
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
        final Person person = new Person(0L, "firstName", "middleName", "lastName", "gender", LocalDate.of(2017, 1, 1), new Commune(0L, "groupName", Arrays.asList()));
        when(mockPersonService.getPerson(0L)).thenReturn(person);

        // Run the test
        final Person result = personControllerUnderTest.getPerson(0L);

        // Verify the results
    }

    @Test
    void testUpdatePerson() {
        // Setup
        final Person person = new Person(0L, "firstName", "middleName", "lastName", "gender", LocalDate.of(2017, 1, 1), new Commune(0L, "groupName", Arrays.asList()));
        when(mockPersonService.updatePerson(any(Person.class))).thenReturn(0L);

        // Run the test
        final Long result = personControllerUnderTest.updatePerson(person);

        // Verify the results
        assertEquals(0L, result);
    }

    @Test
    void testCreatePerson() {
        // Setup
        final Person person = new Person(0L, "firstName", "middleName", "lastName", "gender", LocalDate.of(2017, 1, 1), new Commune(0L, "groupName", Arrays.asList()));
        when(mockPersonService.createPerson(any(Person.class))).thenReturn(0L);

        // Run the test
        final Long result = personControllerUnderTest.createPerson(person);

        // Verify the results
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
