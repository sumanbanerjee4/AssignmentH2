package com.example.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.model.Contacts;
import com.example.assignment.repo.ContactRepo;

@Service
public class ContactService {
	
	@Autowired
	ContactRepo contactsRepository;
	
	public Contacts createContacts(Contacts contacts){
		Contacts Contacts1 = contactsRepository.save(contacts);
		return Contacts1;
		
	}

	public List<Contacts> getAllContacts() {
		List<Contacts> ContactsList = contactsRepository.findAll();
		return ContactsList;
	}

	public String updateContacts(Contacts contacts) {
		contactsRepository.save(contacts);
		return "Contacts Sucessfully updated";
	}

	public String deleteContacts(String name) {
		contactsRepository.deleteById(name);
		return "Contacts Sucessfully deleted";
	}
	
	public String deleteAll() {
		contactsRepository.deleteAll();
		return "Contacts Sucessfully deleted";
	}
	
	public Optional<Contacts> getContactByName(String name) {
		Optional<Contacts>contact= contactsRepository.findByName(name);
		return contact;
	}

}