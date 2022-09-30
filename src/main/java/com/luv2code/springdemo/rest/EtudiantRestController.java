package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Etudiant;

@RestController
@RequestMapping("/api")
public class EtudiantRestController {
	
	private List<Etudiant> Etudiant;
	
	// define @PostConstruct pour charger les données des étudiants ... seulement une fois
	
	@PostConstruct
	public void chargerDonnées() {
		Etudiant = new ArrayList<>();
		Etudiant.add(new Etudiant("Emmanuel","Macron"));
		Etudiant.add(new Etudiant("Jean-Luc","Mélenchon"));
		Etudiant.add(new Etudiant("Marine","Lepen"));
	}
	
	//define endpoint for "etudiant" - donne la liste des etudiants
	
		@GetMapping("/etudiant")
		public List<Etudiant> getEtudiant(){
			return Etudiant;
		}
	
	//definir un point de fin pour "/etudiant/{etudiantId}" donne un étudiant à l'index
	
		@GetMapping("/etudiant/{etudiantId}")
		public Etudiant getEtudiant(@PathVariable int etudiantId) {

		//just index into the list ... keep it simple for now
			//vérifier l'id de l'étudiant contre la longueur de la liste
			
			if( (etudiantId >= Etudiant.size()) || (etudiantId <0)){
				throw new EtudiantNonTrouveException("L'ID de l'étudiant n'a pas été trouvé - " + etudiantId);
			}

		return Etudiant.get(etudiantId);
	}
		
		@ExceptionHandler
		public ResponseEntity<EtudiantErreurReponse> handleException(EtudiantNonTrouveException eww) {
			
			//créer la réponse de l'erreur etudiant
			
			EtudiantErreurReponse erreur = new EtudiantErreurReponse();
			
			erreur.setStatut(HttpStatus.NOT_FOUND.value());
			erreur.setMessage(eww.getMessage());
			erreur.setTimbreDeTemps(System.currentTimeMillis());
			
			
			//et on return ResponseEntity
			
			return new ResponseEntity<>(erreur, HttpStatus.NOT_FOUND);
		}	
		
		// rajoutons un autre gestionnaire d'exception mais pour attraper toutes les exceptions (gotta catch them all)
		
		 @ExceptionHandler
		 public ResponseEntity<EtudiantErreurReponse> handleException(Exception eww){
			//créer la réponse de l'erreur etudiant
				
				EtudiantErreurReponse erreur = new EtudiantErreurReponse();
				
				erreur.setStatut(HttpStatus.BAD_REQUEST.value());
				erreur.setMessage(eww.getMessage());
				erreur.setTimbreDeTemps(System.currentTimeMillis());
				
				//et on return ResponseEntity
				
				return new ResponseEntity<>(erreur, HttpStatus.BAD_REQUEST);
		 }
		
	}
