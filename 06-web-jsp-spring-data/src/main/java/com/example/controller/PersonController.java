package com.example.controller;

import com.example.facade.PersonFacade;
import com.example.model.Filter;
import com.example.model.Person;
import com.example.model.PersonGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.FileEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jchrzanows001 on 2017-01-15.
 */
@Controller
public class PersonController {

  @Autowired
  private PersonGenerator personGenerator;

  @Autowired
  private PersonFacade personFacade;

  @RequestMapping("/start")
  public ModelAndView hello(@RequestParam("name") String name, ModelAndView modelAndView) {
    modelAndView.addObject("name", name);
    modelAndView.setViewName("new");
    return modelAndView;
  }

  @RequestMapping("/persons")
  public ModelAndView personList(ModelAndView modelAndView) {
    List<Person> persons = personFacade.findAll();
    modelAndView.addObject("persons", persons);
    modelAndView.setViewName("persons");
    return modelAndView;
  }

  @RequestMapping("/generate")
  @ResponseBody
  public String generateData() {
    List<Person> persons = personGenerator.generateMockData();
    for (Person person : persons) {
      personFacade.save(person);
    }
    return "Success, data generated!";
  }

  @RequestMapping("/add")
  public ModelAndView addPersonForm(ModelAndView modelAndView) {
    modelAndView.addObject("person", new Person());
    modelAndView.setViewName("form");
    return modelAndView;
  }

  @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
  public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult, ModelAndView modelAndView) {
    if (bindingResult.hasErrors()) {
      modelAndView.setViewName("form");
      return modelAndView;
    }
    personFacade.save(person);
    modelAndView.addObject("persons", personFacade.findAll());
    modelAndView.setViewName("/persons");
    return modelAndView;
  }

  @RequestMapping("/find")
  public ModelAndView findPersonByName(
          @RequestParam("name") String name) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("persons", personFacade.findByNameLike(name));
    modelAndView.setViewName("/persons");
    return modelAndView;
  }

  @RequestMapping("/filter")
  public ModelAndView filterPersons(@ModelAttribute("filter") Filter filter, ModelAndView modelAndView) {
    modelAndView.addObject("filter", filter);
    modelAndView.addObject("persons", personFacade.filter(filter));
    return modelAndView;
  }

}
