package com.gestion.achat.service;

import java.util.List;
import java.util.Set;

import com.gestion.achat.entity.Facture;

public interface FactureService {

	List<Facture> retrieveAllFactures();
	void cancelFacture(Long id);
	Facture retrieveFacture(Long id);
	void assignOperateurToFacture(Long idOperateur, Long idFacture);
	public Set<Facture> getFacturesByFournisseur(Long idFournisseur);
}
