package com.example.controller;

import com.example.model.Filter;
import com.example.model.Person;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-03-04.
 */
@Controller
public class PersonController {

    private static final Logger LOGGER = Logger.getLogger(PersonController.class);

    @Value("${rest.resource.person.findOne}")
    private String personUrl;

    @Value("${rest.resource.person.findAll}")
    private String personsUrl;

    @Value("${rest.resource.person.filter}")
    private String personsFilterUrl;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("person")
    public ModelAndView getPerson(@RequestParam("id") String id, ModelAndView modelAndView) {
        Person person = null;
        try {
            person = restTemplate.getForObject(personUrl, Person.class, id);
        } catch (HttpStatusCodeException e) {
            LOGGER.error(e.getMessage());
        }
        String test = personUrl;
        modelAndView.addObject("person", person);
        modelAndView.setViewName("/new");
        return modelAndView;
    }

    @RequestMapping("persons")
    public ModelAndView getPersons(ModelAndView modelAndView) {
        Person[] persons = null;
        try {
            persons = restTemplate.getForObject(personsUrl, Person[].class);
        } catch (HttpStatusCodeException e) {
            LOGGER.error(e.getMessage());
        }
        List<Person> personsList = Arrays.asList(persons);
        //Arrays.stream(persons).collect(Collectors.toList());
        modelAndView.addObject("persons", personsList);
        modelAndView.setViewName("/persons");
        return modelAndView;
    }
    @RequestMapping("/filter")
    public ModelAndView getFilteredPersons(ModelAndView modelAndView) {
        Filter filter = new Filter();
        filter.setName("A");
        Person[] persons = restTemplate.postForObject(personsFilterUrl,filter,Person[].class);
        modelAndView.addObject("persons",persons);
        modelAndView.setViewName("persons");
        return modelAndView;
    }


    @RequestMapping("/start")
    public ModelAndView hello(@RequestParam("name") String name, ModelAndView modelAndView) {
        modelAndView.addObject("name", name);
        modelAndView.setViewName("new");
        return modelAndView;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }



}
