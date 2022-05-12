package com.cim.typeA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.cim.typeA.repository")
@EntityScan(basePackages = {"com.cim.typeA.model"})

public class TypeAApplication {

	public static void main(String[] args) {
		SpringApplication.run(TypeAApplication.class, args);
	}

}
