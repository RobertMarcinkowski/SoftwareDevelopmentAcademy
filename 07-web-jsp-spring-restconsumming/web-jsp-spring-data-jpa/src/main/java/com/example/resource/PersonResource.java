package com.example.resource;

import com.example.facade.PersonFacade;
import com.example.model.Filter;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by RENT on 2017-03-04.
 */
@RestController
public class PersonResource {

    @Autowired
    private PersonFacade personFacade;

    @RequestMapping("/resource/person/{id}")
    public Person getPerson(@PathVariable("id") String id) {
        return personFacade.findOne(Long.parseLong(id));
    }

    @RequestMapping("/resource/persons")
    public List<Person> getAllPersons() {
        return personFacade.findAll();
    }

    @RequestMapping(value = "/resource/persons/filter",method = RequestMethod.POST)
    public List<Person> filteredPersons(@RequestBody Filter filter) {
        return personFacade.filter(filter);
    }

}
