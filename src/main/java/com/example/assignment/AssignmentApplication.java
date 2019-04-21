package com.example.assignment;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.assignment.model.Contacts;
import com.example.assignment.repo.ContactRepo;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class AssignmentApplication {
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
		
		
		
	}

}
