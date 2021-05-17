package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;

@SpringBootApplication
@EnableDiscoveryClient
public class RecoendationServiceApplication implements CommandLineRunner {

	private ProductDao productDao;

	@Autowired
	public RecoendationServiceApplication(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(RecoendationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productDao.save(new Product("Product1", "Description1", "link1"));
		productDao.save(new Product("Product2", "Description2", "link2"));
		productDao.save(new Product("Product3", "Description3", "link3"));
		productDao.save(new Product("Product4", "Description4", "link4"));

	}

}
