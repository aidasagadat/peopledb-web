package data;

import com.companyname.peopledbweb.biz.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// @Component
public class PersonDataLoader implements ApplicationRunner {

    private PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(personRepository.count()==0) {
            List<Person> people = List.of(
                    new Person(null, "Aida", "Sagadat", LocalDate.of(2005, 6, 18),"aidasagadat@gmail.com", new BigDecimal(10000000)),
                    new Person(null, "Dana", "Sagadat", LocalDate.of(2008, 6, 15),"aidasagadat@gmail.com", new BigDecimal(10000000)),
                    new Person(null, "Hamza", "Sagadat", LocalDate.of(2016, 1, 8),"aidasagadat@gmail.com", new BigDecimal(10000000)),
                    new Person(null, "Tair", "Sagadat", LocalDate.of(2016, 1, 8),"aidasagadat@gmail.com", new BigDecimal(10000000)),
                    new Person(null, "Arman", "Komarov", LocalDate.of(1987, 2, 27),"aidasagadat@gmail.com", new BigDecimal(10000000)),
                    new Person(null, "Lola", "Boranbaeva", LocalDate.of(2008, 6, 18),"aidasagadat@gmail.com", new BigDecimal(10000000))
            );
            personRepository.saveAll(people);
        }
    }
}
