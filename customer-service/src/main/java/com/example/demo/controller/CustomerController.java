package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	
	private CustomerService customerService;
	private Environment environment;
	@Autowired
	public CustomerController(CustomerService customerService, Environment environment) {
		super();
		this.customerService = customerService;
		this.environment = environment;
	}
	
	@GetMapping("/status")
	public ResponseEntity<String> getStatus()
	{
		return ResponseEntity.ok("status up--> port number: "+environment.getProperty("local.server.port"));
	}
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> displayAllCustomer()
	{
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomer());
	}
	
}
