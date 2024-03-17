package com.companyname.peopledbweb.web.controller;

import com.companyname.peopledbweb.biz.model.Person;
import data.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/people")
@Controller
public class PeopleController {

    private PersonRepository personRepository;

    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ModelAttribute("people")
    public Iterable<Person> getpeople(){
        return personRepository.findAll();
    }

    @ModelAttribute
    public Person getPerson(){
        return new Person();
    }

    @GetMapping
    public String showPeoplePage(){
        return "people";
    }

    @PostMapping
    public String savePerson(Person person){
        System.out.println(person);
        return "people";
    }

}













