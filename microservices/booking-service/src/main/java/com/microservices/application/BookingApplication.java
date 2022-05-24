package com.microservices.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.microservices.application","com.exceptions" })
public class BookingApplication{
	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}
} 
