package com.search.service.search.models;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Hotel {
	@Id
	private BigInteger hotelID;
	private String location;
	
	@Override
	public String toString() {
		return "Hotel [hotelID=" + hotelID + ", location=" + location + "]";
	}

	public BigInteger getHotelID() {
		return hotelID;
	}

	public void setHotelID(BigInteger hotelID) {
		this.hotelID = hotelID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Hotel(BigInteger hotelID, String location) {
		super();
		this.hotelID = hotelID;
		this.location = location;
	}

	public Hotel() {}
}



//@Entity
//public class Hotel {
//	@Id
//	private BigInteger hotelID;
//	private String location;
//	@OneToMany(mappedBy="hotel")
//	private List<Room> rooms;	
//	@Override
//	public String toString() {
//		return "Hotel [hotelID=" + hotelID + ", location=" + location + ", rooms=" + rooms + "]";
//	}
//	public Hotel(BigInteger hotelID, String location, List<Room> rooms) {
//		super();
//		this.hotelID = hotelID;
//		this.location = location;
//		this.rooms = rooms;
//	}
//	public BigInteger getHotelID() {
//		return hotelID;
//	}
//	public void setHotelID(BigInteger hotelID) {
//		this.hotelID = hotelID;
//	}
//	public String getLocation() {
//		return location;
//	}
//	public void setLocation(String location) {
//		this.location = location;
//	}
//	public List<Room> getRooms() {
//		return rooms;
//	}
//	public void setRooms(List<Room> rooms) {
//		this.rooms = rooms;
//	}
//	public Hotel() {}
//}
