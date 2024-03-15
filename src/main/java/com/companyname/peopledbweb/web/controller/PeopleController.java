package com.companyname.peopledbweb.web.controller;

import com.companyname.peopledbweb.biz.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/people")

public class PeopleController {
    @GetMapping
    public String getPeople(Model model){
        List<Person> people = List.of(
                new Person(1l,"Aida","Sagadat", LocalDate.of(2005, 6,18), new BigDecimal(10000000)),
                new Person(2l,"Dana","Sagadat", LocalDate.of(2008, 6,15), new BigDecimal(10000000)),
                new Person(3l,"Hamza","Sagadat", LocalDate.of(2016, 1,8), new BigDecimal(10000000)),
                new Person(4l,"Tair","Sagadat", LocalDate.of(2016, 1,8), new BigDecimal(10000000)),
                new Person(5l,"Arman","Komarov", LocalDate.of(1987, 2,27), new BigDecimal(10000000)),
                new Person(6l,"Ilnara","Boranbaeva", LocalDate.of(2008, 6,18), new BigDecimal(10000000))
        );
        model.addAttribute("people", people);
        return "people";
    }
}
