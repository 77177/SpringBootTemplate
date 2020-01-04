package com.template.demo.person.services;

import com.template.demo.person.models.Person;
import com.template.demo.person.repositories.PersonRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public Person getPerson(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("The person with id " + id + " doesn't exist"));
    }

    @Transactional
    public Long updatePerson(Person person) {

        Long id = person.getId();

        if (personRepository.existsById(id)){
            Person updatedPerson = personRepository.save(person);
            return updatedPerson.getId();
        } else {
            throw new IllegalArgumentException("The person with id " + id + " doesn't exist");
        }
    }

    @Transactional
    public Long createPerson(Person person) {

        Long id = person.getId();

        if (personRepository.existsById(id)){
            throw new IllegalArgumentException("The person with id " + id + " exists");
        } else {
            Person savedPerson = personRepository.save(person);
            return savedPerson.getId();
        }
    }

    @Transactional
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Transactional
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @Transactional
    public void deleteAllPersons(){
        personRepository.deleteAll();
    }
}
