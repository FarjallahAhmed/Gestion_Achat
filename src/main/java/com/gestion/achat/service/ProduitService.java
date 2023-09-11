package com.gestion.achat.service;

import java.util.List;

import com.gestion.achat.entity.Produit;

public interface ProduitService {

	List<Produit> retrieveAllProduits();
	Produit addProduit(Produit p, Long idCategorieProduit, Long idStock);
	Produit updateProduit(Produit p, Long idCategorieProduit, Long idStock);
	Produit retrieveProduit(Long id);
	void assignProduitToStock(Long idProduit, Long idStock);
	
	
}
