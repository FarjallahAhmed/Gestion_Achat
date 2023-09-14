package com.gestion.achat.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.achat.entity.Facture;
import com.gestion.achat.service.FactureService;
import com.gestion.achat.utils.ResponseWrapper;

import jakarta.websocket.server.PathParam;



@RestController
@RequestMapping("/factures")
public class FactureController {

	
	@Autowired
	FactureService factureService;
	
	
	@GetMapping
	public ResponseEntity<ResponseWrapper<List<Facture>>> getFactures(){
		
		List<Facture> factures = factureService.retrieveAllFactures();
		
		if (factures.isEmpty()) {
			String message = "Failed to retrieved any of the factures";
			ResponseWrapper<List<Facture>> response = new ResponseWrapper<>(null, message);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);	
		}else {
			String message = "Successfully retrieved all the factures";
			ResponseWrapper<List<Facture>> response = new ResponseWrapper<>(factures, message);
			return ResponseEntity.ok(response);	
		}
		
	}
	
	@PutMapping("/cancel/{id}")
	public ResponseEntity<ResponseWrapper<Long>> cancelFacture(@PathVariable("id") Long id) {
		
		factureService.cancelFacture(id);
		String message = "Successfully archived facture with ID: "+ id;
		ResponseWrapper<Long> response = new ResponseWrapper<>(id,message);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseWrapper<Facture>> getFacture(@PathVariable("id") Long id) {
		Facture facture = factureService.retrieveFacture(id);
		
		if(facture == null) {
			String errorMessage = "Facture with ID: " + id + "Not Found";
			ResponseWrapper<Facture> response = new ResponseWrapper<>(null, errorMessage); 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}else {
			String message = "Successfully retrived Facture with ID: " + id;
			ResponseWrapper<Facture> response = new ResponseWrapper<>(facture,message);
			return ResponseEntity.ok(response);
		}
		
	}
	
	
	@PostMapping("/assign-operateur")
	public ResponseEntity<ResponseWrapper<Long>> assignOperateurToFacture(@RequestParam Long idOperateur, @RequestParam Long idFacture) {
		
		factureService.assignOperateurToFacture(idOperateur, idFacture);
		String message = "Successfully assign Operateur with ID: "+ idOperateur + " To Facture with ID : " + idFacture;
		ResponseWrapper<Long> response = new ResponseWrapper<>(null,message);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/by-fournisseur")
	public ResponseEntity<ResponseWrapper<Set<Facture>>> getFacturesByFournisseur(@RequestParam Long idFournisseur){
		 Set<Facture> factures = factureService.getFacturesByFournisseur(idFournisseur);
		
		if (factures.isEmpty()) {
			String message = "Failed to retrieved any of the factures by fourniseur";
			ResponseWrapper<Set<Facture>> response = new ResponseWrapper<>(null, message);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);	
		}else {
			String message = "Successfully retrieved all the factures";
			ResponseWrapper<Set<Facture>> response = new ResponseWrapper<>(factures, message);
			return ResponseEntity.ok(response);	
		}
		
	}
	
	@PostMapping("/add-facture")
	public ResponseEntity<ResponseWrapper<Facture>> addFacture(@RequestBody Facture facture,@PathParam("IdFournisseur") Long idFournisseur) {
		
		Facture f = factureService.addFacture(facture, idFournisseur);
		
		String message = "Sccessefuly added the Factre";
		ResponseWrapper<Facture> response = new ResponseWrapper<>(f,message);
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/pourcentage-recouvrement")
	public ResponseEntity<ResponseWrapper<Float>> pourcentageRecouvrement(@PathVariable("sDate") Date startDate,
	                                                                      @PathVariable("eDate") Date endDate) {
	    float percentage = factureService.pourcentageRecouvrement(startDate, endDate);
	    String message = "Pourcentage recouvrement calculated successfully.";
	    ResponseWrapper<Float> response = new ResponseWrapper<>(percentage, message);
	    return ResponseEntity.ok(response);
	}

	
	
	
	
	
	
	
	
	
}
