package com.example.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.model.Contacts;

import com.example.assignment.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@GetMapping("/all")
    public List<Contacts> getAll() {
        return contactService.getAllContacts();
	}
	@PostMapping("/createContact")
	public Contacts createUserDetails(@RequestBody Contacts contacts){
		return contactService.createContacts(contacts);
	}
	
	@GetMapping("/{name}")
	public Optional<Contacts> getContactByName(@PathVariable String name) {
		return contactService.getContactByName(name);
	}
	
	@PostMapping("/updateContacts")
	public String updateUserDetails(@RequestBody Contacts contacts){
		return contactService.updateContacts(contacts);
	}
	
	@GetMapping("/delete/{name}")
	public String deleteUserDetails(@PathVariable String name){
		return contactService.deleteContacts(name);
	}
	@GetMapping("/deleteAll")
	public String deleteAll(){
		return contactService.deleteAll();
	}
	

}
