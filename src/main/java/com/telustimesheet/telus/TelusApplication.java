package com.telustimesheet.telus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TelusApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelusApplication.class, args);
	}

}
