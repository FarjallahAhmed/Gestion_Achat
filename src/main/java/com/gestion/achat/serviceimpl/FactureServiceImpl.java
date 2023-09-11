package com.gestion.achat.serviceimpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.achat.entity.Facture;
import com.gestion.achat.entity.Fournisseur;
import com.gestion.achat.entity.Operateur;
import com.gestion.achat.repository.FactureRepository;
import com.gestion.achat.service.FactureService;
import com.gestion.achat.service.FournisseurService;
import com.gestion.achat.service.OperateurService;

@Service
public class FactureServiceImpl implements FactureService{
	
	
	@Autowired
	FactureRepository factureRepository;

	@Autowired
	OperateurService operateurService;
	
	@Autowired
	FournisseurService fournisseurService;
	
	@Override
	public List<Facture> retrieveAllFactures() {
		
		return factureRepository.findAll();
	}

	@Override
	public void cancelFacture(Long id) {
		Facture f = factureRepository.findById(id).orElse(null);
		f.setActive(true);
		factureRepository.save(f);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		
		return factureRepository.findById(id).orElse(null);
	}

	@Override
	public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
		
		Operateur operateur = operateurService.retrieveOperateur(idOperateur);
		Facture facture = factureRepository.findById(idFacture).orElse(null);
		
		operateur.getFactures().add(facture);
		
		operateurService.addOperateur(operateur);
		
		
	}

	@Override
	public Set<Facture> getFacturesByFournisseur(Long idFournisseur) {
		
		Fournisseur fournisseur = fournisseurService.retrieveFournisseur(idFournisseur);
		Set<Facture> factures = fournisseur.getFactures();
		
		
		
		return factures;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
