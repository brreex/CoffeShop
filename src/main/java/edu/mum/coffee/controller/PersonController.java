package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@RestController
public class PersonController {
	PersonService personService = new PersonService();
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping(value="/ws/person",method=RequestMethod.POST)
	public void addPerson(@RequestBody Person person){
		personService.savePerson(person);
	}
	
	@RequestMapping(value="/ws/person/{email}",method=RequestMethod.GET)
	public List<Person> getAllPersons(@PathVariable String email){
		return personService.findByEmail(email);
	}
	
	@RequestMapping(value="/ws/person/{id}",method=RequestMethod.GET)
	public Person getPerson(@RequestAttribute long id){
		return personService.findById(id);
	}
	
	@RequestMapping(value="/ws/person/{id}",method=RequestMethod.DELETE)
	public void deletePerson(@RequestBody Person person){
		personService.removePerson(person);
	}
}
