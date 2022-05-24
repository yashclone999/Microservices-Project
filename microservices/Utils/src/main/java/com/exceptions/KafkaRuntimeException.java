package com.exceptions;

@SuppressWarnings("serial")
public class KafkaRuntimeException extends RuntimeException{
	
	public KafkaRuntimeException(String message) {
		super(message);
	}
}

