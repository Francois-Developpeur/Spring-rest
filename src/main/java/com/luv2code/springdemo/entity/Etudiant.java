package com.luv2code.springdemo.entity;

public class Etudiant {

	private String prenom;
	private String nom;
	
	public Etudiant() {
		
	}

	public Etudiant(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
