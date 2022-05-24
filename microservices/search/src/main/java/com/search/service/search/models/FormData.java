package com.search.service.search.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class FormData {
	private String location;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private BigInteger userID;
	private Integer numRooms;
	private BigDecimal priceStart;
	private BigDecimal priceEnd;
	public FormData(String location, Date startDate, Date endDate, BigInteger userID, Integer numRooms,
			BigDecimal priceStart, BigDecimal priceEnd) {
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userID = userID;
		this.numRooms = numRooms;
		this.priceStart = priceStart;
		this.priceEnd = priceEnd;
	}
	public FormData() {}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public BigDecimal getPriceStart() {
		return priceStart;
	}
	public void setPriceStart(BigDecimal priceStart) {
		this.priceStart = priceStart;
	}
	public BigDecimal getPriceEnd() {
		return priceEnd;
	}
	public void setPriceEnd(BigDecimal priceEnd) {
		this.priceEnd = priceEnd;
	}
}
