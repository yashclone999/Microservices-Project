package com.microservices.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.application.models.Booking;
import com.microservices.application.models.FormData;
import com.microservices.application.services.BookingService;

import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	
	@PostMapping("/book")
	public Booking createBooking(@RequestBody FormData data) throws Exception{
		Booking currBooking = bookingService.createBooking(data);				
		return currBooking;
	}
	
}
