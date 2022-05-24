package com.exceptions;

@SuppressWarnings("serial")
public class RoomsNotAvailable extends RuntimeException{
	
	public RoomsNotAvailable(String message) {
		super(message);
	}
	
}
