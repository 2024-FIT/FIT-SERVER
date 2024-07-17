package com.hackerton.fit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class FitApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitApplication.class, args);
	}

}
