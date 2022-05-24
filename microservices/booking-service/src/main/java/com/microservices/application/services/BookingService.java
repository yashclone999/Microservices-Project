package com.microservices.application.services;

import java.math.BigInteger;

import com.microservices.application.models.Booking;
import com.microservices.application.models.FormData;


public interface BookingService {
	public Booking createBooking(FormData data) throws Exception;
	public Booking confirmBooking(BigInteger currBookingID, String UserMail) throws Exception;
	public void cancelBooking(BigInteger currBookingID, String UserMail) throws Exception;
	public Booking findBookingByID(BigInteger id);
	public Iterable<Booking> getBookings();
}
