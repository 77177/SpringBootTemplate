package com.template.demo.person.services;

import com.template.demo.person.models.Person;
import com.template.demo.person.repositories.PersonRepository;
import com.test.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class PersonServiceTest {

    @Mock
    private PersonRepository mockPersonRepository;

    private PersonService personServiceUnderTest;

    private TestDataGenerator testDataGenerator = new TestDataGenerator();

    @BeforeEach
    void setUp() {
        initMocks(this);
        personServiceUnderTest = new PersonService(mockPersonRepository);
    }

    @Test
    void testGetPerson() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // Setup
        final Person person = testDataGenerator.getTestObject(Person.class);
        final Optional<Person> personOptional = Optional.of(person);

        // Configure PersonRepository.findById(...).
        when(mockPersonRepository.findById(person.getId())).thenReturn(personOptional);

        // Run the test
        final Person result = personServiceUnderTest.getPerson(person.getId());

        // Verify the results
        verify(mockPersonRepository).findById(person.getId());
        assertEquals(person, result);
    }

    @Test
    void testUpdatePerson() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // Setup
        final Person person = testDataGenerator.getTestObject(Person.class);

        when(mockPersonRepository.existsById(person.getId())).thenReturn(true);

        // Configure PersonRepository.save(...).
        when(mockPersonRepository.save(any(Person.class))).thenReturn(person);

        // Run the test
        final Long result = personServiceUnderTest.updatePerson(person);

        // Verify the results
        verify(mockPersonRepository).save(any(Person.class));
        assertEquals(person.getId(), result);
    }

    @Test
    void testCreatePerson() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // Setup
        final Person person = testDataGenerator.getTestObject(Person.class);

        when(mockPersonRepository.existsById(person.getId())).thenReturn(false);

        // Configure PersonRepository.save(...).
        person.setId(1L);
        when(mockPersonRepository.save(any(Person.class))).thenReturn(person);

        // Run the test
        final Long result = personServiceUnderTest.createPerson(person);

        // Verify the results
        verify(mockPersonRepository).save(any(Person.class));
        assertEquals(1L, result);
    }

    @Test
    void testDeleteAllPersons() {
        // Setup

        // Run the test
        personServiceUnderTest.deleteAllPersons();

        // Verify the results
        verify(mockPersonRepository).deleteAll();
    }

    @Test
    void testGetAllPersons() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // Setup

        // Configure PersonRepository.findAll(...).
        final List<Person> peopleList = Collections.singletonList(testDataGenerator.getTestObject(Person.class));
        when(mockPersonRepository.findAll()).thenReturn(peopleList);

        // Run the test
        final List<Person> result = personServiceUnderTest.getAllPersons();

        // Verify the results
        verify(mockPersonRepository).findAll();
        assertEquals(peopleList, result);
    }

    @Test
    void testDeletePerson() {
        // Setup
        long id = 0L;

        // Run the test
        personServiceUnderTest.deletePerson(id);

        // Verify the results
        verify(mockPersonRepository).deleteById(id);
    }
}
