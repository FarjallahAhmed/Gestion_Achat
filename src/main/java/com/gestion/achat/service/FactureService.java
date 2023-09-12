package com.gestion.achat.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.gestion.achat.entity.Facture;

public interface FactureService {

	List<Facture> retrieveAllFactures();
	void cancelFacture(Long id);
	Facture retrieveFacture(Long id);
	void assignOperateurToFacture(Long idOperateur, Long idFacture);
	Set<Facture> getFacturesByFournisseur(Long idFournisseur);
	Facture addFacture(Facture f, Long idFournisseur);
	float pourcentageRecouvrement(Date startDate, Date endDate);
}
