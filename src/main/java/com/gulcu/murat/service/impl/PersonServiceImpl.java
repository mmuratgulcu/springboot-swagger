package com.gulcu.murat.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gulcu.murat.dao.PersonRepository;
import com.gulcu.murat.entities.Person;
import com.gulcu.murat.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	private final PersonRepository personRepository;
	
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

	@Override
	public Boolean deleteById(Long id) {
		Person person = personRepository.getOne(id);
		if(person == null)
			return Boolean.FALSE;
		personRepository.deleteById(id);
		return Boolean.TRUE;
	}

	@Override
	public Person update(Person person, Long id) {
		Optional<Person> result = personRepository.findById(id);
		System.out.println(result.get());		
		result.get().setName(person.getName());
		result.get().setSurname(person.getSurname());
		return personRepository.save(result.get());
	}

	@Override
	public Optional<Person> findById(Long id) {
		// TODO Auto-generated method stub
		return personRepository.findById(id);
	}

}
