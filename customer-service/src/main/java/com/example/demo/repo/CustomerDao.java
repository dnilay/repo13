package com.example.demo.repo;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerDao {
	
	public Customer createCustomer(Customer customer);
	
	public List<Customer> getAllCustomer();

}
