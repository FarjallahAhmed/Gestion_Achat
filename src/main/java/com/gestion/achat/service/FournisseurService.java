package com.gestion.achat.service;

import java.util.List;

import com.gestion.achat.entity.Fournisseur;

public interface FournisseurService {
	
	List<Fournisseur> retrieveAllFournisseurs();
	Fournisseur addFournisseur(Fournisseur f);
	Fournisseur updateFournisseur(Fournisseur f);
	Fournisseur retrieveFournisseur(Long id);

}
