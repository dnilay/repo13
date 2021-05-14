package com.example.demo.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.model.Product;

@Repository
@EnableTransactionManagement
public class ProductRepositoryImpl implements ProductRepository {

	private EntityManager entityManager;

	@Autowired
	public ProductRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		entityManager.persist(product);
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("select P from Product P");
		return query.getResultList();
	}

}
