package com.gestion.achat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.achat.entity.CategorieProduit;
import com.gestion.achat.service.CategorieProduitService;
import com.gestion.achat.utils.ResponseWrapper;


@RestController
@RequestMapping("categorieproduits")
public class CategorieProduitController {

	@Autowired
	CategorieProduitService categorieProduitService;
	
	
	
	@GetMapping
	public  ResponseEntity<ResponseWrapper<List<CategorieProduit>>> getAllCategorieProduits(){
		
		List<CategorieProduit> categorieProduits = categorieProduitService.retrieveAllCategorieProduits();
		
		if(categorieProduits.isEmpty()) {
			
			String message = "Categorie Prosuit is empty ";
			ResponseWrapper<List<CategorieProduit>> response = new ResponseWrapper<>(null,message);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}else {
			String message = "Succefuly retrieved all the Categorie Procuit ";
			ResponseWrapper<List<CategorieProduit>> response = new ResponseWrapper<>(categorieProduits,message);
			return ResponseEntity.ok(response);
		}
		
	
	}
	
	@PostMapping
	public  ResponseEntity<ResponseWrapper<CategorieProduit>> addCategorieProduit(@RequestBody CategorieProduit categorieProduit) {
		CategorieProduit c =categorieProduitService.addCategorieProduit(categorieProduit);
		
		String message = "Sucessfuly Added Categorie Produit ";
		ResponseWrapper<CategorieProduit> response = new ResponseWrapper<>(c,message);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	public ResponseEntity<ResponseWrapper<CategorieProduit>> updateCategorieProduit(@RequestBody CategorieProduit categorieProduit) {
		CategorieProduit c =categorieProduitService.addCategorieProduit(categorieProduit);
		
		String message = "Sucessfuly updated Categorie Produit ";
		ResponseWrapper<CategorieProduit> response = new ResponseWrapper<>(c,message);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseWrapper<CategorieProduit>> retrieveCategorieProduit(@PathVariable("id") Long id) {
		
		CategorieProduit categorieProduit = categorieProduitService.retriCategorieProduit(id);
		
		if(categorieProduit != null) {
			String message = "Sucessfuly retrieved Categorie Produit with ID :" + id;
			ResponseWrapper<CategorieProduit> response = new ResponseWrapper<>(categorieProduit,message);
			return ResponseEntity.ok(response);
		}else {
			String message = "Sucessfuly retrieved Categorie Produit with ID :" + id;
			ResponseWrapper<CategorieProduit> response = new ResponseWrapper<>(null,message);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseWrapper<Long>>removeCategorieProduit(@PathVariable("id") Long id) {
		categorieProduitService.deleteCategorieProduit(id);
		
		String message = "Sucessfuly deleted Categorie Produit with ID:  "+ id;
		ResponseWrapper<Long> response = new ResponseWrapper<>(id,message);
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	
	
	
	
	
	
}
