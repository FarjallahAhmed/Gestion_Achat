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

import com.gestion.achat.entity.Operateur;
import com.gestion.achat.service.OperateurService;


@RestController
public class OperateurController {

	
	@Autowired
	OperateurService operateurService;
	
	
	@GetMapping("retrieve-all-operateur")
	public List<Operateur> getAllOperateur(){
		return operateurService.retrieveAllOperateurs();
	}
	
	@PostMapping("add-operateu")
	public Operateur addOperateur(@RequestBody Operateur operateur) {
		return operateurService.addOperateur(operateur);
	}
	
	@PutMapping("update-operateur")
	public Operateur updateOperateur(@RequestBody Operateur operateur) {
		return operateurService.upOperateur(operateur);
	}
	
	@GetMapping("retrieve-operateur/{id}")
	public Operateur getOperateur(@PathVariable("id") Long id) {
		return operateurService.retrieveOperateur(id);
	}
	
	@DeleteMapping("delete-operateur/{id}")
	public void deleteOperateur(@PathVariable("id") Long id) {
		operateurService.removeOperateur(id);
	}
	
	
	
	
}
