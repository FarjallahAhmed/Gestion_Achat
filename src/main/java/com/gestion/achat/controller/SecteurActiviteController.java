package com.gestion.achat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.achat.entity.SecteurActivite;
import com.gestion.achat.service.SecteurActiviteService;

import jakarta.websocket.server.PathParam;

@RestController
public class SecteurActiviteController {

	
	@Autowired
	SecteurActiviteService secteurActiviteService;
	
	
	@GetMapping("get-all-secteur-activite")
	public List<SecteurActivite> getSecteurActivites(){
		
		return secteurActiviteService.retrieveAllSecteurActivites();
	}
	
	@PostMapping("add-secteur-activite")
	public SecteurActivite addSecteurActivite(@RequestBody SecteurActivite secteurActivite) {
		
		return secteurActiviteService.addSecteurActivite(secteurActivite);
	}
	
	@PutMapping("update-secteur-activite")
	public SecteurActivite updateSecteurActivite(@RequestBody SecteurActivite secteurActivite) {
		
		return secteurActiviteService.updateSecteurActivite(secteurActivite);
	}
	
	@GetMapping("get-secteur-activite/{id}")
	public SecteurActivite getSecteurActivite(@PathParam("id") Long id) {
		
		return secteurActiviteService.retrieveSecteurActivite(id);
	}
	
	@DeleteMapping("delete-secteur-activite/{id}")
	public void deleteSecteurActivite(@PathParam("id") Long id) {
		
		secteurActiviteService.removeSecteurActivite(id);
	}
	
	
	
	
	
	
	
	
	
}
