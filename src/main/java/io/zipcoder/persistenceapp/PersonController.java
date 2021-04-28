package io.zipcoder.persistenceapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController {

    @Autowired
    PersonService service;

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPersonById(@PathVariable int id){
        try {
            Person person = service.getPersonById(id);
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
        catch(EmptyResultDataAccessException e){
            return new ResponseEntity<>("Person Not Found In Database",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPersons () {
        try{
            List<Person> people = service.getAllPerson();
            return new ResponseEntity<>(people, HttpStatus.OK);
        }
        catch(EmptyResultDataAccessException e){
            return new ResponseEntity<>("No People Currently In Database", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePerson(@PathVariable int id) {
        try {
            service.deletePerson(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(EmptyResultDataAccessException e){
            return new ResponseEntity<>("Person Not Found In Database",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public ResponseEntity<?> addPerson(@RequestBody Person person){
        service.addPerson(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePerson(@PathVariable int id, @RequestBody Person person){
        try {
            service.getPersonById(id);
        }
        catch(EmptyResultDataAccessException e){
            return new ResponseEntity<>("Person Not Found In Database",HttpStatus.NOT_FOUND);
        }
        service.updatePerson(person, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/person/reverselookup/{mobile}", method = RequestMethod.GET)
    public ResponseEntity<?> getPersonByMobile(@PathVariable String mobile){
        try{
            Person person = service.getPersonByMobile(mobile);
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
        catch(EmptyResultDataAccessException e){
            return new ResponseEntity<>("Person With"+mobile+" Number Not Found", HttpStatus.BAD_REQUEST);
        }

    }
    @RequestMapping(value="/person/surname/{lastname}", method = RequestMethod.GET)
    public ResponseEntity<?> getPersonByLastName(@PathVariable String lastName){
        try{
            List<Person> people = service.getPersonByLastName(lastName);
            return new ResponseEntity<>(people, HttpStatus.OK);
        }
        catch(EmptyResultDataAccessException e){
            return new ResponseEntity<>("Person with lastname"+lastName+"not found",HttpStatus.BAD_REQUEST);
        }
    }
}