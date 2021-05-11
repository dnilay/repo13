package com.example.demo.service;

import com.example.demo.model.CustomerEntity;
import com.example.demo.shared.CustomerDto;

public interface CustomerService {
	
	public CustomerEntity createCustomer(CustomerDto customerDto);

}
