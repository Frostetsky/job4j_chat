package com.nikita.rest_api_chat.services;


import com.nikita.rest_api_chat.dao.PersonRepository;
import com.nikita.rest_api_chat.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person saveOrUpdate(Person person) {
        return personRepository.save(person);
    }

    @Override
    @Transactional
    public void delete(Person person) {
        personRepository.delete(person);
    }

    @Override
    public Optional<Person> findById(int id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
