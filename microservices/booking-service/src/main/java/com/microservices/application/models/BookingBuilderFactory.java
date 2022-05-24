package com.microservices.application.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;


public class BookingBuilderFactory {
	
	private BigInteger roomID;
	private Date startDate;
	private Date endDate;
	private BigInteger userID;
	private String status;
	private String invoice;
	private Integer numRooms;
	private BigDecimal price;
	private String email; 
	private Date creationTime;
	
	public BookingBuilderFactory setRoomID(BigInteger roomID) {this.roomID = roomID;return this;}
	public BookingBuilderFactory setStartDate(Date startDate) {this.startDate = startDate; return this;}
	public BookingBuilderFactory setEndDate(Date endDate) {this.endDate = endDate; return this;}
	public BookingBuilderFactory setUserID(BigInteger userID) {this.userID = userID; return this;}
	public BookingBuilderFactory setStatus(String status) {this.status = status; return this;}
	public BookingBuilderFactory setInvoice(String invoice) {this.invoice = invoice; return this;}
	public BookingBuilderFactory setNumRooms(Integer numRooms) {this.numRooms = numRooms; return this;}
	public BookingBuilderFactory setPrice(BigDecimal price) {this.price = price; return this;}
	public BookingBuilderFactory setMail(String email) {this.email = email; return this;}
	public BookingBuilderFactory setCreationTime(Date creationTime) {this.creationTime = creationTime; return this;}
	
	public Booking build() {
		return new Booking(roomID, startDate, endDate, userID, status, invoice, numRooms, price, email, creationTime);
	}
}
