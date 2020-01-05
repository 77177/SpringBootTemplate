package com.template.demo.person.controllers;

import com.template.demo.person.models.Person;
import com.template.demo.person.services.PersonService;
import com.test.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class PersonControllerTest {

    @Mock
    private PersonService mockPersonService;

    private PersonController personControllerUnderTest;

    private TestDataGenerator testDataGenerator = new TestDataGenerator();

    @BeforeEach
    void setUp() {
        initMocks(this);
        personControllerUnderTest = new PersonController(mockPersonService);
    }

    @Test
    void testGetPerson() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // Setup

        // Configure PersonService.getPerson(...).
        final Person person = testDataGenerator.getTestObject(Person.class);
        when(mockPersonService.getPerson(person.getId())).thenReturn(person);

        // Run the test
        final Person result = personControllerUnderTest.getPerson(person.getId());

        // Verify the results
        verify(mockPersonService).getPerson(person.getId());
        assertEquals(person, result);
    }

    @Test
    void testUpdatePerson() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // Setup
        final Person person = testDataGenerator.getTestObject(Person.class);

        when(mockPersonService.updatePerson(person)).thenReturn(person.getId());

        // Run the test
        final Long result = personControllerUnderTest.updatePerson(person);

        // Verify the results
        verify(mockPersonService).updatePerson(person);
        assertEquals(person.getId(), result);
    }

    @Test
    void testCreatePerson() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // Setup
        final Person person = testDataGenerator.getTestObject(Person.class);

        long createdId = 1L;
        when(mockPersonService.createPerson(person)).thenReturn(createdId);

        // Run the test
        final Long result = personControllerUnderTest.createPerson(person);

        // Verify the results
        verify(mockPersonService).createPerson(person);
        assertEquals(createdId, result);
    }

    @Test
    void testDeletePerson() {
        // Setup
        long id = 0L;

        // Run the test
        personControllerUnderTest.deletePerson(id);

        // Verify the results
        verify(mockPersonService).deletePerson(id);
    }
}
