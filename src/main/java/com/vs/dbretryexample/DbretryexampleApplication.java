package com.vs.dbretryexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class DbretryexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbretryexampleApplication.class, args);
	}

}
