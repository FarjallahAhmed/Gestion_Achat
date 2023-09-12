package com.gestion.achat.service;

import java.util.Date;
import java.util.List;

import com.gestion.achat.entity.Reglement;

public interface ReglementService {
	
	List<Reglement> retrieveAllReglements();
	Reglement addReglement(Reglement r);
	Reglement retrieveReglement(Long id);
	List<Reglement> retrieveReglementByFacture(Long idFacture);
	float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

}
