package com.microservices.application.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;


public class FormData {
	
	private BigInteger roomID;
	private Date startDate;
	private Date endDate;
	private BigInteger userID;
	private Integer numRooms;
	private BigDecimal price;
	private String mail;
	@Override
	public String toString() {
		return "FormData [roomID=" + roomID + ", startDate=" + startDate + ", endDate=" + endDate + ", userID=" + userID
				+ ", numRooms=" + numRooms + ", price=" + price + ", mail=" + mail + "]";
	}
	public FormData(BigInteger roomID, Date startDate, Date endDate, BigInteger userID, Integer numRooms,
			BigDecimal price, String mail) {
		super();
		this.roomID = roomID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userID = userID;
		this.numRooms = numRooms;
		this.price = price;
		this.mail = mail;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
	public FormData() {}
}
