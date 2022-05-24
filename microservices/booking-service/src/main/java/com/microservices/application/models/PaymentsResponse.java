package com.microservices.application.models;

import java.math.BigInteger;

public class PaymentsResponse {
	private BigInteger bookingID;
	private String userID;
	public BigInteger getBookingID() {
		return bookingID;
	}
	public void setBookingID(BigInteger bookingID) {
		this.bookingID = bookingID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "PaymentsResponse [bookingID=" + bookingID + ", userID=" + userID + "]";
	}
	public PaymentsResponse() {
		super();
	}
	public PaymentsResponse(BigInteger bookingID, String userID) {
		super();
		this.bookingID = bookingID;
		this.userID = userID;
	}
	
	
}
