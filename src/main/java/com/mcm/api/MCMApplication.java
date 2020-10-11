package com.mcm.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MCMApplication {

	public static void main(String[] args) {
		SpringApplication.run(MCMApplication.class, args);
	}

}
