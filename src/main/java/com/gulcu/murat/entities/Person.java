package com.gulcu.murat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "person")
@Data
@ApiModel(value = "Benim person nesnem",description = "Benim person")
public class Person{
	
	@Id
	@SequenceGenerator(name = "person_gen",sequenceName = "person_seq",allocationSize = 1)
	@GeneratedValue(generator = "person_gen",strategy = GenerationType.SEQUENCE)
	@ApiModelProperty(value = "Person nesnesinin tekil Id alanı")
	private Long id;
	@ApiModelProperty(value = "Person nesnesinin Adı alanı",required = false)
	private String name;
	@ApiModelProperty(value = "Person nesnesinin Soyadı alanı",required = false)
	private String surname;

	public Person() {
		
	}
	
	public Person(Long id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	
	
}
