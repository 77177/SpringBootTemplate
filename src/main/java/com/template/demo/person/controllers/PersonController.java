package com.template.demo.person.controllers;

import com.template.demo.person.models.Person;
import com.template.demo.person.services.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/get/{id}")
    public Person getPerson(@PathVariable("id") Long id) {
        return personService.getPerson(id);
    }

    @PutMapping("/update")
    public Long updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @PostMapping("/create")
    public Long createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
    }


}
