package com.companyname.peopledbweb.web.controller;

import com.companyname.peopledbweb.biz.model.Person;
import data.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")

public class PeopleController {

    private PersonRepository personRepository;

    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ModelAttribute("people")
    public Iterable<Person> getpeople(){
        return personRepository.findAll();
    }

    @GetMapping
    public String showPeoplePage(Model model){
        return "people";
    }
}
