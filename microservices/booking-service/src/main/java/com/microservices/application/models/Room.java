package com.microservices.application.models;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Room {
	@Id
	private BigInteger RoomID;
	private String Type;
	private BigDecimal price;
	private Integer Total;
	@ManyToOne
	private Hotel hotel;
	private String photoURL;
	public BigInteger getRoomID() {
		return RoomID;
	}
	public void setRoomID(BigInteger roomID) {
		RoomID = roomID;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getTotal() {
		return Total;
	}
	public void setTotal(Integer total) {
		Total = total;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	@Override
	public String toString() {
		return "Room [RoomID=" + RoomID + ", Type=" + Type + ", price=" + price + ", Total=" + Total + ", hotel="
				+ hotel + ", photoURL=" + photoURL + "]";
	}
	public Room(BigInteger roomID, String type, BigDecimal price, Integer total, Hotel hotel, String photoURL) {
		super();
		RoomID = roomID;
		Type = type;
		this.price = price;
		Total = total;
		this.hotel = hotel;
		this.photoURL = photoURL;
	}
	public Room() {}
	
}

