package com.gestion.achat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.achat.entity.CategorieProduit;
import com.gestion.achat.service.CategorieProduitService;


@RestController
public class CategorieProduitController {

	@Autowired
	CategorieProduitService categorieProduitService;
	
	
	
	@GetMapping("retrieve-all-categorie-produits")
	public List<CategorieProduit> getAllCategorieProduits(){
		return categorieProduitService.retrieveAllCategorieProduits();
	}
	
	@PostMapping("add-categorie-produit")
	public CategorieProduit addCategorieProduit(@RequestBody CategorieProduit categorieProduit) {
		return categorieProduitService.addCategorieProduit(categorieProduit);
	}
	
	@PutMapping("update-categorie-produit")
	public CategorieProduit updateCategorieProduit(@RequestBody CategorieProduit categorieProduit) {
		return categorieProduitService.addCategorieProduit(categorieProduit);
	}
	
	@GetMapping("retriev-categorie-produit/{id}")
	public CategorieProduit retrieveCategorieProduit(@PathVariable("id") Long id) {
		return categorieProduitService.retriCategorieProduit(id);
	}
	
	@DeleteMapping("remove-categorie-produit")
	public void removeCategorieProduit(@PathVariable("id") Long id) {
		categorieProduitService.deleteCategorieProduit(id);
	}
	
	
	
	
	
	
	
	
	
	
	
}
