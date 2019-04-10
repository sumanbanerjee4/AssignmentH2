package com.example.assignment.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.assignment.model.Contacts;



public interface ContactRepo extends MongoRepository<Contacts, String>{
	
	public Optional<Contacts> findByName(String name);


}
