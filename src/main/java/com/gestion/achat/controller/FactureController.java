package com.gestion.achat.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public void cancelFacture(@PathVariable("id") Long id) {
		
		factureService.cancelFacture(id);
	}
	
	@GetMapping("get-facture/{id}")
	public Facture getFacture(@PathVariable("id") Long id) {
		
		return factureService.retrieveFacture(id);
	}
	
	
	@PostMapping("asign-operateur-to-facture")
	public void assignOperateurToFacture(@RequestParam Long idOperateur, @RequestParam Long idFacture) {
		
		factureService.assignOperateurToFacture(idOperateur, idFacture);
	}
	
	@GetMapping("get-factures-by-fournisseur")
	public Set<Facture> getFacturesByFournisseur(@RequestParam Long idFournisseur){
		return factureService.getFacturesByFournisseur(idFournisseur);
	}
	
	@PostMapping("add-facture")
	public Facture addFacture(@RequestBody Facture facture,@PathParam("IdFournisseur") Long idFournisseur) {
		return factureService.addFacture(facture, idFournisseur);
	}
	
	
	
	
	
	
	
	
	
}
