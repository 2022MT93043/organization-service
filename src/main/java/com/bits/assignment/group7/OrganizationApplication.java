package com.bits.assignment.group7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class OrganizationApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrganizationApplication.class, args);
	}
}
