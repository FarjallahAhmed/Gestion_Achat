package com.gestion.achat.service;

import java.util.List;

import com.gestion.achat.entity.Operateur;

public interface OperateurService {

	List<Operateur> retrieveAllOperateurs();
	Operateur addOperateur(Operateur o);
	Operateur upOperateur(Operateur o);
	Operateur retrieveOperateur(Long id);
	void removeOperateur(Long id);
	
	
}
