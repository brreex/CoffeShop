package edu.mum.coffee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@RestController
public class PersonController {
	PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(value = "/ws/person", method = RequestMethod.POST)
	public ModelAndView addPerson(@ModelAttribute Person person, Model model) {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("products");
		System.out.println(person);
		personService.savePerson(person);
		return mnv;
	}

	@RequestMapping(value = "/ws/persons", method = RequestMethod.GET)
	public List<Person> getallPersons() {
		return personService.getAllPerson();
	}

	@RequestMapping(value = "/ws/person/{email}", method = RequestMethod.GET)
	public Person getAllPersons(@PathVariable String email) {
		System.out.println(email);
		System.out.println(personService.getByFirstName("Berhanu"));
		System.out.println(personService.getByEmail(email));
		return personService.getByEmail(email);
	}

	@RequestMapping(value = "/ws/person/{id}", method = RequestMethod.DELETE)
	public void deletePerson(@PathVariable long id) {
		Person person = personService.findById(id);
		personService.removePerson(person);
	}

	@RequestMapping(value = "/ws/person/{id}", method = RequestMethod.PUT)
	public void disablePerson(@PathVariable long id) {
		Person person = personService.findById(id);
		person.setEnable(false);
		personService.savePerson(person);
	}
}
