package com.gestion.achat.service;

import java.util.List;

import com.gestion.achat.entity.Facture;

public interface FactureService {

	List<Facture> retrieveAllFactures();
	void cancelFacture(Long id);
	Facture retrieveFacture(Long id);
}
