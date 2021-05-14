package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	public Product createProduct(Product product);
	public List<Product> getAllProduct();

}
