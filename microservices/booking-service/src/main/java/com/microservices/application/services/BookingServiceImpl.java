package com.microservices.application.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.exceptions.*;
import com.microservices.application.DAO.AvailableRoomDAO;
import com.microservices.application.DAO.BookingDAO;
import com.microservices.application.models.Booking;
import com.microservices.application.models.BookingBuilderFactory;
import com.microservices.application.models.FormData;

@Component
public class BookingServiceImpl implements BookingService{
	
	private final String reserved = "RESERVED";
	private final String booked = "BOOKED";
	private final String cancelled = "CANCELLED";
	private final Integer TIMEOUT = 24;
	
	@Autowired
	private BookingDAO bookingDAO;
	
	@Autowired
	AvailableRoomDAO availableRoomDAO;
	
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public Booking createBooking(FormData data) throws Exception {
		
		/* Check Availability as requested in Booking */
		
	    Long numDays = TimeUnit.DAYS.convert(data.getEndDate().getTime() - data.getStartDate().getTime(), TimeUnit.MILLISECONDS) + 1;
	    
	    Optional<BigInteger> checkAvailablity = availableRoomDAO.checkAvailablity(data.getRoomID(), data.getStartDate(), data.getEndDate(), data.getNumRooms(), numDays);
		if((checkAvailablity.isEmpty()) || !checkAvailablity.get().toString().equals(data.getRoomID().toString()) ) {
			throw new RoomsNotAvailable("Rooms not available");
		}
		
		
		/* Requested rooms are available, decrease the availability and lock a booking in user's name */
		
		availableRoomDAO.updateReservedRooms(data.getStartDate(), data.getEndDate(), data.getNumRooms(), data.getRoomID());
		
		
		
		/* create booking with reserved status and a lock period */
		
		BookingBuilderFactory bookingBuilder = new BookingBuilderFactory();
		
		Booking booking = bookingBuilder.setRoomID(data.getRoomID())
				.setStartDate(data.getStartDate())
				.setEndDate(data.getEndDate())
				.setUserID(data.getUserID())
				.setStatus(reserved)
				.setNumRooms(data.getNumRooms())
				.setPrice(data.getPrice())
				.setMail(data.getMail())
				.setCreationTime(new Date(Instant.now().toEpochMilli()))
				.build();
	
		booking = bookingDAO.save(booking);
		
		return booking;
		
	}
	
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public Booking confirmBooking(BigInteger currBookingID, String UserMail) throws Exception {
		
		checkBadRequest(currBookingID, UserMail);
		
		Optional<Booking> currBooking = bookingDAO.findById(currBookingID);
		
		if( bookingReservationTimeOut(currBooking.get().getCreationTime()) ) {
			cancelValidBooking(currBookingID);
			throw new Exception("Payment time expired. Any amount deducted will be credited back to your account.");
		}
		
		return confirmValidBooking(currBookingID);
	}
	
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void cancelBooking(BigInteger currBookingID, String UserMail) throws Exception {
		
		checkBadRequest(currBookingID, UserMail);
		
		cancelValidBooking(currBookingID);
	}
	
	
	private void cancelValidBooking(BigInteger currBookingID) {
		Booking booking = bookingDAO.findById(currBookingID).get();
		availableRoomDAO.updateCancelledRooms(booking.getStartDate(), booking.getEndDate(), booking.getNumRooms(), booking.getRoomID());
		booking.setStatus(cancelled);
		booking.setCreationTime(null);
		bookingDAO.save(booking);
	}
	
	private Booking confirmValidBooking(BigInteger currBookingID) {
		Booking booking = bookingDAO.findById(currBookingID).get();
		booking.setStatus(booked);
		booking.setCreationTime(new Date(Instant.now().toEpochMilli()));
		bookingDAO.save(booking);
		return booking;
	}
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	private void deleteBooking(BigInteger id) {
		if(bookingDAO.findById(id).isPresent()) bookingDAO.deleteById(id);
	}

	@Override
	public Iterable<Booking> getBookings() {
		return bookingDAO.findAll();
	}

	@Override
	public Booking findBookingByID(BigInteger id) {
		return bookingDAO.findById(id).get();
	} 
	
	private void checkBadRequest(BigInteger currBookingID, String UserMail) throws Exception {
		if(currBookingID == null) throw new Exception("Bad Request. No such booking found.");
		Optional<Booking> currBooking = bookingDAO.findById(currBookingID);
		if( currBooking.isEmpty() || !currBooking.get().getStatus().equals(reserved) || !currBooking.get().getEmail().equals(UserMail)) {
			throw new Exception("Bad Request. Invalid userID OR booking is not reserved OR no booking found");
		}
	}

	private boolean bookingReservationTimeOut(Date creationTime) {
		Date now = new Date();
		Long elapsedTime = TimeUnit.HOURS.convert(now.getTime() - creationTime.getTime(), TimeUnit.MILLISECONDS);
		return (elapsedTime > TIMEOUT);
	}
}
