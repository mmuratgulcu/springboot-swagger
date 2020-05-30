package com.gulcu.murat.api;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gulcu.murat.entities.Person;
import com.gulcu.murat.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/swagger")
@Api(value = "Benim Person API dokümantasyonum",description = "Benim Person API dokümantasyonu açıklama")
public class PersonController {

	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping("/person/save")
	@ApiOperation(value = "Yeni Person ekleme metodu")
	public ResponseEntity<Person> save (@RequestBody Person person){
		return ResponseEntity.ok(personService.save(person));
	}
	
	@GetMapping("/person/all")
	@ApiOperation(value = "Bütün kayıtları listeleme metodu")
	public ResponseEntity<List<Person>> findAllPerson(){
		return ResponseEntity.ok(personService.findAll());
	}
	
	@GetMapping("/person/find/{id}")
	@ApiOperation(value = "Id'si verilen kullanıcıyı döndüren metod")
	public ResponseEntity<Optional<Person>> findById(@PathVariable("id") @ApiParam(value = "Tekil Id", example ="1" ) Long id) {
		return ResponseEntity.ok(personService.findById(id));
	}
	
	@DeleteMapping("/person/delete/{id}")
	@ApiOperation(value = "Id'si verilen kullanıcıyı silen metod")
	public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id){	
		return ResponseEntity.ok(personService.deleteById(id));
	}
	
	@PutMapping("/person/update/{id}")
	@ApiOperation(value = "Id'si verilen kullanıcıyı güncelleyen metod")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person,@PathVariable("id") Long id){
		return ResponseEntity.ok(personService.update(person, id));
	}
	
}
