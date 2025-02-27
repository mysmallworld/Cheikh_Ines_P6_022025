package com.orion.mdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MddApplication {

	public static void main(String[] args) {
		SpringApplication.run(MddApplication.class, args);
		System.out.println("Welcome to MDD !");
	}

}
