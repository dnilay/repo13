package com.example.demo.controller;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.MatchingStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerEntity;
import com.example.demo.service.CustomerService;
import com.example.demo.shared.CustomerDto;
import com.example.demo.ui.CustomerRequestModel;
import com.example.demo.ui.CustomerResponseModel;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private ModelMapper modelMapper;
	private CustomerService customerService;
	
	
	public CustomerController(ModelMapper modelMapper, CustomerService customerService) {
		super();
		this.modelMapper = modelMapper;
		this.customerService = customerService;
	}


	@PostMapping
	public ResponseEntity<CustomerResponseModel> createCustomer(@RequestBody CustomerRequestModel customerDetails)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CustomerDto customerDto=modelMapper.map(customerDetails, CustomerDto.class);
		customerDto.setCustomerId(UUID.randomUUID().toString());
		CustomerEntity customerEntity=customerService.createCustomer(customerDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(customerEntity, CustomerResponseModel.class));
	}

}
