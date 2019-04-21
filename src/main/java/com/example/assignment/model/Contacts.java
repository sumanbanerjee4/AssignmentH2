package com.example.assignment.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;

@Entity
@Table(name="ContactDetails")
public class Contacts {


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@Version
	@Column(nullable = false)
	private long version;
	
	@Column
	String name;
	
	
	@Column
	int phoneNumber;
	
	
	@Column
	String email;
	
	@Column
	String User;

	
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	public List<Devices> devices;
	
	
	

	
	public Contacts(String name, int phoneNumber, String email, String user, List<Devices> devices) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		User = user;
		this.devices = devices;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUser() {
		return User;
	}


	public void setUser(String user) {
		User = user;
	}


	public List<Devices> getDevices() {
		return devices;
	}


	public void setDevices(List<Devices> devices) {
		this.devices = devices;
	}

	
	
	public Contacts() {}
	
	

  }
