package com.example.facade;

import com.example.model.Filter;
import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        personRepository.save(person);
    }

    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }

    public List<Person> findByNameLike(String name) {
        return personRepository.findByNameIgnoreCaseContaining(name);
    }

    public List<Person> filter(Filter filter) {
        String name = filter.getName();
        String surname = filter.getSurname();
        String orderBy = filter.getOrderBy();
        if(ORDER_BY_NAME.equals(orderBy)) {
            if(isNotEmpty(name) && isNotEmpty(surname)) {
                return personRepository.findByNameAndSurnameOrderByName(name, surname);
            } else if (isNotEmpty(name)) {
                return personRepository.findBySurnameOrderByName(name);
            } else if (isNotEmpty(surname)) {
                return personRepository.findByNameOrderBySurname(surname);
            } else {
                return personRepository.findAllByOrderByName();
            }
        } else {
            if(isNotEmpty(name) && isNotEmpty(surname)) {
                return personRepository.findByNameAndSurnameOrderBySurname(filter.getName(), filter.getSurname());
            } else if (isNotEmpty(name)) {
                return personRepository.findBySurnameOrderBySurname(name);
            } else if (isNotEmpty(surname)) {
                return personRepository.findByNameOrderBySurname(surname);
            } else {
                return personRepository.findAllByOrderBySurname();
            }
        }

    }
    private Boolean isNotEmpty(String string) {
        if(string == null) return false;
        if(string.trim().length() == 0) return false;
        return true;
    }
}
