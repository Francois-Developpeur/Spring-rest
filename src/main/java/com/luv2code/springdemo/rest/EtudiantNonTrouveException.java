package com.luv2code.springdemo.rest;

public class EtudiantNonTrouveException extends RuntimeException {

	public EtudiantNonTrouveException(String message, Throwable cause) {
		super(message, cause);
	}

	public EtudiantNonTrouveException(String message) {
		super(message);
	}

	public EtudiantNonTrouveException(Throwable cause) {
		super(cause);
	}
	
}
