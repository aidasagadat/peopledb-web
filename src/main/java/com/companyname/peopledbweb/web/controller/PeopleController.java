package com.companyname.peopledbweb.web.controller;

import com.companyname.peopledbweb.biz.model.Person;
import data.PersonRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
    public String savePerson(@Valid Person person, Errors errors){
        System.out.println(person);
        if(!errors.hasErrors()){
            personRepository.save(person);
            return "redirect:people";
        }
        return "people";
    }

    @PostMapping(params = "delete=true")
    public String deletePeople(@RequestParam Optional<List<Long>> selections){
       if(selections.isPresent()){
           personRepository.deleteAllById(selections.get());
       }
        return "redirect:people";
    }



    @PostMapping(params = "edit=true")
    public String editPerson(@RequestParam Optional<List<Long>> selections, Model model){
       if(selections.isPresent()){
           Optional<Person> person = personRepository.findById(selections.get().get(0));
           model.addAttribute("person", person);
       }
        return "people";
    }





}


















