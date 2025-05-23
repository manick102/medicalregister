package com.example.medicalregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.medicalregister.repository")
@EntityScan(basePackages = {"com.example"})
public class MedicalRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalRegisterApplication.class, args);
	}

}
