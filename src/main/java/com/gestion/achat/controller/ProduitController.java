package com.gestion.achat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.achat.entity.Produit;
import com.gestion.achat.service.ProduitService;

import jakarta.websocket.server.PathParam;

@RestController
public class ProduitController {

	@Autowired
	ProduitService produitService;
	
	
	@GetMapping("retrieve-all-produits")
	public List<Produit> getAllProduit() {
		return produitService.retrieveAllProduits();
	}
	
	@PostMapping("add-produit")
	public Produit addProduit(@RequestBody Produit p, @RequestParam Long idCategorieProduit, @RequestParam Long idStock) {
		return produitService.addProduit(p, idCategorieProduit, idStock);
	}
	
	@PutMapping("update-produit")
	public Produit updateProduit(@RequestBody Produit p, @RequestParam Long idCategorieProduit, @RequestParam Long idStock) {
		return produitService.addProduit(p, idCategorieProduit, idStock);
	}
	
	@GetMapping("retrieve-produit/{id}")
	public Produit getProduit(@PathParam("id") Long id) {
		return produitService.retrieveProduit(id);
	}
	
	
	
	
}
