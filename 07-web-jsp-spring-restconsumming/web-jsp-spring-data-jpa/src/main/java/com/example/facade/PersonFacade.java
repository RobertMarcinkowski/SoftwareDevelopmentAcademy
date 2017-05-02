package com.example.facade;

import com.example.model.Filter;
import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by RENT on 2017-02-28.
 */
@Service
public class PersonFacade {

    private static final String ORDER_BY_NAME = "name";

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return (List<Person>)personRepository.findAll();
    }

    public void save(Person person) {
        person.setDateCreated(LocalDateTime.now());
        personRepository.save(person);
    }

    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }

    public List<Person> findByNameLike(String name) {
        return personRepository.findByNameIgnoreCaseContaining(name);
    }

    public List<Person> filter(Filter filter) {
        String name = (filter.getName() == null) ? "": filter.getName();
        String surname = (filter.getSurname()==null) ? "": filter.getSurname();
        String orderBy = filter.getOrderBy();

        if (ORDER_BY_NAME.equals(orderBy)) {
                return (List<Person>) personRepository.findByNameIgnoreCaseContainingAndSurnameIgnoreCaseContainingOrderByName(name, surname);
        } else {
                return (List<Person>) personRepository.findByNameIgnoreCaseContainingAndSurnameIgnoreCaseContainingOrderBySurname(name, surname);
        }
    }

    public Person findOne(Long id) {
        return personRepository.findOne(id);
    }

    private Boolean isNotEmpty(String string) {
        if (string == null) return false;
        if ("".equals(string.trim())) return false;
        return true;
    }
}
