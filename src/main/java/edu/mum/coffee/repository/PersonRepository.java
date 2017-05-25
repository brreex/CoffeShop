package edu.mum.coffee.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.coffee.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	public List<Person> findAll();
	public Person findByEmail(String email);
	public Person findByid(long id);
	public Person findByFirstName(String firstName);
}
