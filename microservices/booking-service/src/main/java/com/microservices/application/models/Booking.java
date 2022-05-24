package com.microservices.application.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Booking")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger bookingID;
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
	public Booking(BigInteger roomID, Date startDate, Date endDate, BigInteger userID, String status, String invoice,
			Integer numRooms, BigDecimal price, String email, Date creationTime) {
		super();
		this.roomID = roomID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userID = userID;
		this.status = status;
		this.invoice = invoice;
		this.numRooms = numRooms;
		this.price = price;
		this.email = email;
		this.creationTime = creationTime;
	}
	@Override
	public String toString() {
		return "Booking [bookingID=" + bookingID + ", roomID=" + roomID + ", startDate=" + startDate + ", endDate="
				+ endDate + ", userID=" + userID + ", status=" + status + ", invoice=" + invoice + ", numRooms="
				+ numRooms + ", price=" + price + ", email=" + email + ", creationTime=" + creationTime + "]";
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public BigInteger getBookingID() {
		return bookingID;
	}
	public Booking() {
		super();
	}
	public BigInteger getRoomID() {
		return roomID;
	}
	public void setRoomID(BigInteger roomID) {
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
	public BigInteger getUserID() {
		return userID;
	}
	public void setUserID(BigInteger userID) {
		this.userID = userID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public Integer getNumRooms() {
		return numRooms;
	}
	public void setNumRooms(Integer numRooms) {
		this.numRooms = numRooms;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
