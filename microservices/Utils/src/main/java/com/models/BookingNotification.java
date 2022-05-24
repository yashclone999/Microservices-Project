package com.models;

import java.util.Date;


public class BookingNotification {
	private int bookingID;
	private int numRooms;
	private int roomID;
	private Date startDate;
	private Date endDate;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getNumRooms() {
		return numRooms;
	}
	public void setNumRooms(int numRooms) {
		this.numRooms = numRooms;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public BookingNotification(int bookingID, int numRooms, int roomID, Date startDate, Date endDate, String status) {
		super();
		this.bookingID = bookingID;
		this.numRooms = numRooms;
		this.roomID = roomID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	@Override
	public String toString() {
		return "BookingNotification [bookingID=" + bookingID + ", numRooms=" + numRooms + ", roomID=" + roomID
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}
	public BookingNotification() {
	}
}
