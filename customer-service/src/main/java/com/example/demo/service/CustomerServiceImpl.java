package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerEntity;
import com.example.demo.repo.CustomerDao;
import com.example.demo.shared.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	private ModelMapper modelMapper;
	private CustomerDao customerDao;

	public CustomerServiceImpl(ModelMapper modelMapper, CustomerDao customerDao) {
		super();
		this.modelMapper = modelMapper;
		this.customerDao = customerDao;
	}

	@Override
	public CustomerEntity createCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CustomerEntity customerEntity=modelMapper.map(customerDto, CustomerEntity.class);
		return customerDao.save(customerEntity);
	}

}
