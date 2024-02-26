package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TeamAppBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamAppBuilderApplication.class, args);
	}

}
