package com.intern.bugs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@SpringBootApplication
public class BugsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugsApplication.class, args);
	}
}
