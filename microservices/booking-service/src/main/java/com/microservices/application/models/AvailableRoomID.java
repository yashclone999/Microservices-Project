package com.microservices.application.models;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class AvailableRoomID implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private BigInteger RoomID;
	@Temporal(TemporalType.DATE)
	private Date date;
	public AvailableRoomID() {};
	public AvailableRoomID(BigInteger roomID, Date date) {
		RoomID = roomID;
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(RoomID, date);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvailableRoomID other = (AvailableRoomID) obj;
		return Objects.equals(RoomID, other.RoomID) && Objects.equals(date, other.date);
	}
	
}
