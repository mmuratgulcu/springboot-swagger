package com.gulcu.murat.service;

import java.util.List;
import java.util.Optional;

import com.gulcu.murat.entities.Person;

public interface PersonService {
	Person save(Person person);
	List<Person> findAll();
	Boolean deleteById(Long id);
	Person update(Person person,Long id);
	Optional<Person> findById(Long id);

}
