package com.gestion.achat.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.achat.entity.DetailFournisseur;
import com.gestion.achat.entity.Fournisseur;
import com.gestion.achat.entity.SecteurActivite;
import com.gestion.achat.repository.DetailFournisseurRepository;
import com.gestion.achat.repository.FournisseurRepository;
import com.gestion.achat.service.FournisseurService;
import com.gestion.achat.service.SecteurActiviteService;


@Service
public class FournisseurServiceImpl implements FournisseurService {
	
	
	@Autowired
	FournisseurRepository fournisseurRepository;
	
	@Autowired
	DetailFournisseurRepository detailFournisseurRepository;
	
	@Autowired
	SecteurActiviteService secteurActiviteService;
	

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		
		return fournisseurRepository.findAll();
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		
		DetailFournisseur detailFournisseur = f.getDetailFournisseur();
		
		detailFournisseurRepository.save(detailFournisseur);
		
		return fournisseurRepository.save(f);
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		
		return fournisseurRepository.save(f);
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		
		return fournisseurRepository.findById(id).orElse(null);
	}

	@Override
	public void assignSecteurActiviteToFournisseur(Long fournisseurId, Long secteurActiviteId) {
		
		SecteurActivite secteurActivite = secteurActiviteService.retrieveSecteurActivite(secteurActiviteId);
		Fournisseur fournisseur = fournisseurRepository.findById(fournisseurId).orElse(null);
		
		fournisseur.getActivites().add(secteurActivite);
		fournisseurRepository.save(fournisseur);
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
