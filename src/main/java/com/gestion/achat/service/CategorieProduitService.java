package com.gestion.achat.service;

import java.util.List;

import com.gestion.achat.entity.CategorieProduit;

public interface CategorieProduitService {
	
	List<CategorieProduit> retrieveAllCategorieProduits();
	CategorieProduit addCategorieProduit(CategorieProduit cp);
	CategorieProduit updateCategorieProduit(CategorieProduit cp);
	CategorieProduit retriCategorieProduit(Long id);
	void deleteCategorieProduit(Long id);

}
