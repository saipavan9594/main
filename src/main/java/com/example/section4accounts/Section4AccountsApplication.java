package com.example.section4accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Section4AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section4AccountsApplication.class, args);
	}

}
