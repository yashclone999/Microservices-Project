package com.microservices.application.models;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class SBMessage implements Serializable{
	private int bookingID;
	private int numRooms;
	private int roomID;
	private Date startDate;
	private Date endDate;
	private String email;
	@Override
	public String toString() {
		return email+";"+"Dear "+email.split("@")[0]+",\n \n"+"Booking with reference ID "+bookingID+" is confirmed."+"\n \nRoom number "+roomID+" starting from "+startDate.toString()+" to "+endDate.toString()+" is booked under your name, with number of rooms booked as "+numRooms+".";
	}
	public SBMessage(int bookingID, int numRooms, int roomID, Date startDate, Date endDate, String email) {
		super();
		this.bookingID = bookingID;
		this.numRooms = numRooms;
		this.roomID = roomID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.email = email;
	}
}
