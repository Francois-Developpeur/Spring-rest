package com.luv2code.springdemo.rest;

public class EtudiantErreurReponse {
	private int statut;
	private String message;
	private long timbreDeTemps;
	
	public EtudiantErreurReponse() {
		
	}

	public EtudiantErreurReponse(int statut, String message, long timbreDeTemps) {
		this.statut = statut;
		this.message = message;
		this.timbreDeTemps = timbreDeTemps;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimbreDeTemps() {
		return timbreDeTemps;
	}

	public void setTimbreDeTemps(long timbreDeTemps) {
		this.timbreDeTemps = timbreDeTemps;
	}
	
	
}
