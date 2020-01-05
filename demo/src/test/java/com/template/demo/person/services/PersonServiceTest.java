package com.template.demo.person.services;

import com.template.demo.person.models.Person;
import com.template.demo.person.repositories.PersonRepository;
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

class PersonServiceTest {

    @Mock
    private PersonRepository mockPersonRepository;

    private PersonService personServiceUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        personServiceUnderTest = new PersonService(mockPersonRepository);
    }

    @Test
    void testGetPerson() {
        // Setup

        // Configure PersonRepository.findById(...).
        final Person person1 = new Person();
        final Optional<Person> person = Optional.of(person1);
        when(mockPersonRepository.findById(0L)).thenReturn(person);

        // Run the test
        final Person result = personServiceUnderTest.getPerson(0L);

        // Verify the results
        verify(mockPersonRepository).findById(0L);
    }

    @Test
    void testUpdatePerson() {
        // Setup
        final Person person = new Person();

        when(mockPersonRepository.existsById(0L)).thenReturn(true);

        // Configure PersonRepository.save(...).
        final Person person1 = new Person();
        when(mockPersonRepository.save(any(Person.class))).thenReturn(person1);

        // Run the test
        final Long result = personServiceUnderTest.updatePerson(person);

        // Verify the results
        verify(mockPersonRepository).save(any(Person.class));
        assertEquals(0L, result);
    }

    @Test
    void testCreatePerson() {
        // Setup
        final Person person = new Person();

        when(mockPersonRepository.existsById(0L)).thenReturn(false);

        // Configure PersonRepository.save(...).
        final Person person1 = new Person();
        when(mockPersonRepository.save(any(Person.class))).thenReturn(person1);

        // Run the test
        final Long result = personServiceUnderTest.createPerson(person);

        // Verify the results
        verify(mockPersonRepository).save(any(Person.class));
        assertEquals(0L, result);
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
    void testGetAllPersons() {
        // Setup

        // Configure PersonRepository.findAll(...).
        final List<Person> people = Arrays.asList(new Person(0L, "firstName", "lastName"));
        when(mockPersonRepository.findAll()).thenReturn(people);

        // Run the test
        final List<Person> result = personServiceUnderTest.getAllPersons();

        // Verify the results
        verify(mockPersonRepository).findAll();
        assertEquals(people, result);
    }

    @Test
    void testDeletePerson() {
        // Setup

        // Run the test
        personServiceUnderTest.deletePerson(0L);

        // Verify the results
        verify(mockPersonRepository).deleteById(0L);
    }
}
