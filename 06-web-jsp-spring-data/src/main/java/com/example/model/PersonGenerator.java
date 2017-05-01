package com.example.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-02-28.
 */
@Component
public class PersonGenerator {

    public List<Person> generateMockData() {

        List<Person> persons = new ArrayList<>();
        Person person = new Person();
        person.setName("Jan");
        person.setSurname("Nowak");
        person.setPesel("12345678910");
        persons.add(person);

        Person person2 = new Person();
        person2.setName("Tomasz");
        person2.setSurname("Kowalski");
        person2.setPesel("091321321");
        persons.add(person2);

        Person person3 = new Person();
        person3.setName("Anna");
        person3.setSurname("Nowak");
        person3.setPesel("1111111111");
        persons.add(person3);

        return persons;
    }
}
