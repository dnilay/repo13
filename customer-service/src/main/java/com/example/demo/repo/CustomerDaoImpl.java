package com.example.demo.repo;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.model.Customer;
@Repository
@EnableTransactionManagement
public class CustomerDaoImpl implements CustomerDao {

	private EntityManager entityManager;
	
	@Autowired
	public CustomerDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customer.setCustomerId(UUID.randomUUID().toString());
		Session session=entityManager.unwrap(Session.class);
		session.save(customer);
		return customer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomer() {
		Session session=entityManager.unwrap(Session.class);
		Query query=session.createQuery("SELECT C FROM Customer C");
		return query.getResultList();
	}

}
