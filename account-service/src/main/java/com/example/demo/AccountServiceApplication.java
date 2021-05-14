package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.AccountRepository;
import com.example.demo.model.Account;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountServiceApplication implements CommandLineRunner{

	private AccountRepository accountRepository;
	
	
	
	public AccountServiceApplication(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountRepository.save(new Account(1, "John"));
		accountRepository.save(new Account(2, "Marry"));
		
	}

}
