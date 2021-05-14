package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductService productService;

	private Environment environment;
	@Autowired
	public ProductController(ProductService productService, Environment environment) {
		super();
		this.productService = productService;
		this.environment = environment;
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product)
	{
		product.setProductId(UUID.randomUUID().toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
	}

	

	@GetMapping
	public ResponseEntity<List<Product>> displayAllProduct()
	{
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProduct());
	}
	@GetMapping("/status")
	public ResponseEntity<String> getStatus()
	{
		return ResponseEntity.ok("status up-->port number: "+environment.getProperty("local.server.port"));
	}
}
