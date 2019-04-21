package com.example.assignment.controller;

import java.util.Collection;
import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.Util;
import com.example.assignment.model.Contacts;
import com.example.assignment.repo.ContactRepo;
import com.google.common.collect.Lists;

import io.swagger.models.Contact;

@RestController
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	ContactRepo contactService;

	@GetMapping("/all")
	public Iterable<Contacts> getAll() {
		return contactService.findAll();
	}

	@PostMapping("/createContact")
	public Contacts createUserDetails(@RequestBody Contacts contacts) {
		return contactService.save(contacts);
	}

	@GetMapping("/{name}")
	public Optional<Contacts> getContactByName(@PathVariable String name) {
		return contactService.findByName(name);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/updateContacts/{name}")
	ResponseEntity<?> deleteContacts(@PathVariable Integer ContactsId) {
		try {
			contactService.deleteById(ContactsId);
			return Util.createResponseEntity("Data deleted successfully", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return Util.createResponseEntity("Resource not found", HttpStatus.NOT_FOUND);
		}
	}
	//	@PutMapping("/updateContacts/{name}")
	//	public Contacts updateUserDetails(@RequestBody Contacts contacts){
	//		return contactService.save(contacts);
	//	}

	@PutMapping("updateByDeviceName/{device}")
	public String modifyByDeviceName(@PathVariable("device") String device, @Valid @RequestBody Contacts contact) {
		List<Contacts> AllContact = contactService.findBydeviceName(device);
		Contacts latestVersion = AllContact.get(0);
		if (latestVersion != null) {
			latestVersion.setEmail(contact.getEmail());
			latestVersion.setName(contact.getName());
			latestVersion.setUser(contact.getUser());
			latestVersion.setPhoneNumber(contact.getPhoneNumber());
			contactService.save(latestVersion);
			return latestVersion.toString();
		}

		return "Invalid Request";
	}

	@GetMapping("getByDeviceName/{deviceName}")
	public Contacts getContactByDevice(@PathVariable String deviceName) {

		List<Contacts> AllContact = contactService.findBydeviceName(deviceName);
		Contacts latestVersion = AllContact.get(0);
		return latestVersion;

	}

	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		contactService.deleteAll();
	}
}

//	    @RequestMapping(method = RequestMethod.GET)
//	    Collection<Contacts> getAllContactss() {
//	        return Lists.newArrayList(contactService.findAll());
//	    }
//
//	    @RequestMapping(method = RequestMethod.GET, value = "ContactsName/{ContactsName}")
//	    Optional<Contacts> getContactsByContactsName(@PathVariable String name) {
//	        return contactService.findByName(name);
//	    }
//
//	    @RequestMapping(method = RequestMethod.GET, value = "ContactsId/{ContactsId}")
//	    Contacts getContactsById(@PathVariable Integer ContactsId) {
//	        return Util.findOneById(contactService, ContactsId);
//	    }
//
//	    @RequestMapping(method = RequestMethod.POST)
//	    ResponseEntity<?> addContacts(@RequestBody Contacts Contacts) {
//	        if (Util.save(contactService, new Contacts(Contacts.getContactsName(), Contacts.getQuestionCount())) != null) {
//	            return Util.createResponseEntity("Successful creation of a resource", HttpStatus.CREATED);
//	        }
//	        return Util.createResponseEntity("Error creating resource", HttpStatus.BAD_REQUEST);
//	    }
//
//	    @RequestMapping(method = RequestMethod.PUT, value = "ContactsId/{ContactsId}")
//	    ResponseEntity<?> updateContacts(@RequestBody Contacts Contacts, @PathVariable long ContactsId) {
//	        Contacts newContacts = Util.findOneById(contactService, ContactsId);
//	        if (newContacts != null) {
//	            newContacts.setContactsName(Contacts.getContactsName());
//	            newContacts.setQuestionCount(Contacts.getQuestionCount());
//	            if (Util.save(contactService, newContacts).getId().equals(ContactsId)) {
//	                return Util.createResponseEntity("Data updated successfully", HttpStatus.OK);
//	            }
//	        }
//	        return Util.createResponseEntity("Error updating data", HttpStatus.NOT_FOUND);
//	    }
//
//	    @RequestMapping(method = RequestMethod.DELETE, value = "ContactsId/{ContactsId}")
//	    ResponseEntity<?> deleteContacts(@PathVariable long ContactsId) {
//	        try {
//	            contactService.delete(ContactsId);
//	            return Util.createResponseEntity("Data deleted successfully", HttpStatus.ACCEPTED);
//	        } catch (Exception e) {
//	            return Util.createResponseEntity("Resource not found", HttpStatus.NOT_FOUND);
//	        }
//	    }
//
//	}
