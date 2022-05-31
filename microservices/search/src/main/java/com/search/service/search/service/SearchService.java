package com.search.service.search.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.functionalInterfaces.FunctionalInterfacesImpl;
import com.exceptions.*;
import com.search.service.search.DAO.AvailableRoomDAO;
import com.search.service.search.DAO.HotelDAO;
import com.search.service.search.DAO.RoomDAO;
import com.search.service.search.models.FormData;
import com.search.service.search.models.Room;

@Service
public class SearchService {
	
	@Autowired
	AvailableRoomDAO availableRoomDAO;
	
	@Autowired
	RoomDAO roomDAO;
	
	@Autowired
	HotelDAO hotelDAO;
	
	public List<Room> search(FormData data) throws Exception{
		
		Set<BigInteger> availableRooms = new HashSet<>();
		List<Room> rooms = new ArrayList<>();
		
		/* Check available rooms */
		
		Long numDays = TimeUnit.DAYS.convert(data.getEndDate().getTime() - data.getStartDate().getTime(), TimeUnit.MILLISECONDS) + 1;
		availableRoomDAO.findAvailableRooms(data.getStartDate(), data.getEndDate(), data.getNumRooms(), numDays).forEach(availableRooms::add);
		if(FunctionalInterfacesImpl.checkNullSet.test(availableRooms)) throw new RoomsNotAvailable("Rooms not available");
		
		/* Check if any available rooms are in price range and location */
		
		roomDAO.findByLocationAndPrice(data.getLocation(), data.getPriceStart(), data.getPriceEnd()).forEach((room) -> {
			if(availableRooms.contains(room.getRoomID())) rooms.add(room);
		});
		if(FunctionalInterfacesImpl.checkNullList.test(rooms)) throw new RoomsNotAvailable("Rooms not available");
		
		return rooms;
	}
	
	public List<String> locations(){
		Set<String> locations = new HashSet<>();
		hotelDAO.findAll().forEach(hotel -> locations.add(hotel.getLocation()));
		return new ArrayList<String>(locations);
	}
}
