package com.microservices.application.models;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@IdClass(AvailableRoomID.class)
public class AvailableRoom {
	
	@Id
	private BigInteger RoomID;
	@Id
	@Temporal(TemporalType.DATE)
	private Date date;
	private Integer Quantity;
	
	public AvailableRoom(BigInteger roomID, Date date, Integer quantity) {
		super();
		RoomID = roomID;
		this.date = date;
		Quantity = quantity;
	}
	
	public BigInteger getRoomID() {
		return RoomID;
	}
	public void setRoomID(BigInteger roomID) {
		RoomID = roomID;
	}
	public AvailableRoom() {}
	@Override
	public String toString() {
		return "AvailableRoom [RoomID=" + RoomID + ", date=" + date + ", Quantity=" + Quantity + "]";
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	
	
}



