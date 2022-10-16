package com.simsim.solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LifeSolutionLunchApplication {

	public static void main(String[] args) {
		SpringApplication.run(LifeSolutionLunchApplication.class, args);
	}

}
