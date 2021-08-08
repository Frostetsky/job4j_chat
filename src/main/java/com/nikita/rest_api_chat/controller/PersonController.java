package com.nikita.rest_api_chat.controller;

import com.nikita.rest_api_chat.entity.Person;
import com.nikita.rest_api_chat.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public List<Person> findAllPersons() {
        return personService.findAll();
    }

    @PostMapping("/")
    public Person addPerson(@RequestBody Person person) {
        return personService.saveOrUpdate(person);
    }

    @PutMapping("/")
    public void updatePerson(@RequestBody Person person) {
        personService.saveOrUpdate(person);
    }

    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable int id) {
        return personService.findById(id).orElseThrow(NoSuchFieldError::new);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id) {
        personService.delete(findPersonById(id));
    }

}
