package com.example.demo.repo;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductRepository {
	
	public Product createProduct(Product product);
	public List<Product> getAllProduct();

}
