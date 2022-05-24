package com.microservices.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.microservices.application.models.Booking;
import com.microservices.application.models.SBMessage;

@Service
public class ServiceBusMessageService {
	
	@Autowired
	private ServiceBusSenderClient sender;
	
	public void sendMessage(Booking booking) throws Exception{
			
		SBMessage message = new SBMessage(
				booking.getBookingID().intValue(),
				booking.getNumRooms().intValue(),
				booking.getRoomID().intValue(),
				booking.getStartDate(),
				booking.getEndDate(),
				booking.getEmail()); 

		sender.sendMessage(new ServiceBusMessage(
				message.toString())
				.setMessageId(booking.getBookingID().toString()));
	}
}
