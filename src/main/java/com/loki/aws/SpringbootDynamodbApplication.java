package com.loki.aws;

import com.loki.aws.entity.Person;
import com.loki.aws.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SpringbootDynamodbApplication {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/savePerson")
    public Person savePerson(@RequestBody Person person){
        return personRepository.addPerson(person);
    }

    @GetMapping("/getPerson/{personId}")
    public Person getPerson(@PathVariable String personId){
        return personRepository.findPersonByPersonId(personId);
    }

    @DeleteMapping("/deletePerson")
    public Person deletePerson(@RequestBody Person person){
        return personRepository.deletePerson(person);
    }

    @PutMapping("/editPerson")
    public String updatePerson(@RequestBody Person person){
        return personRepository.editPerson(person);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDynamodbApplication.class, args);
    }

}
