package com.gestion.achat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.achat.entity.Fournisseur;
import com.gestion.achat.service.FournisseurService;

import jakarta.websocket.server.PathParam;

@RestController
public class FournisseurController {

	
	@Autowired
	FournisseurService fournisseurService;
	
	
	@GetMapping("get-all-founisseur")
	public List<Fournisseur> getFournisseurs(){
		
		return fournisseurService.retrieveAllFournisseurs();
	}
	
	@PostMapping("add-fournisseur")
	public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur) {
		
		return fournisseurService.addFournisseur(fournisseur);
	}
	
	@PutMapping("update-fournisseur")
	public Fournisseur updateFournisseur(@RequestBody Fournisseur fournisseur) {
		
		return fournisseurService.updateFournisseur(fournisseur);
	}
	
	@GetMapping("get-fournisseur/{id}")
	public Fournisseur getFournisseur(@PathParam("id") Long id) {
		
		return fournisseurService.retrieveFournisseur(id);
	}
	
	
	
	
	
	
	
}
