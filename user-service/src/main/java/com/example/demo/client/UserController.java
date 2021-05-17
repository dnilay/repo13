package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.ui.Product;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private RestTemplate restTemplate;

	@Autowired
	public UserController(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	@GetMapping
	public ResponseEntity<Product[]> personalized()
	{
		Product[] result=restTemplate.getForObject("http://recommendation-service/recommendations", Product[].class);
		return new ResponseEntity<Product[]>(result,HttpStatus.OK);
	}
	

}
