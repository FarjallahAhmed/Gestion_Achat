package com.gestion.achat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.achat.entity.Facture;
import com.gestion.achat.service.FactureService;

import jakarta.websocket.server.PathParam;

@RestController
public class FactureController {

	
	@Autowired
	FactureService factureService;
	
	
	@GetMapping("get-all-facture")
	public List<Facture> getFactures(){
		
		return factureService.retrieveAllFactures();
	}
	
	@PutMapping("cancel-facture/{id}")
	public void cancelFacture(@PathParam("id") Long id) {
		
		factureService.cancelFacture(id);
	}
	
	@GetMapping("get-facture/{id}")
	public Facture getFacture(@PathParam("id") Long id) {
		
		return factureService.retrieveFacture(id);
	}
	
	
	
	
	
	
	
	
	
	
}
