package com.gestion.achat.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.achat.entity.DetailFacture;
import com.gestion.achat.entity.Facture;
import com.gestion.achat.entity.Fournisseur;
import com.gestion.achat.entity.Operateur;
import com.gestion.achat.entity.Produit;
import com.gestion.achat.repository.DetailFactureRepository;
import com.gestion.achat.repository.FactureRepository;
import com.gestion.achat.service.FactureService;
import com.gestion.achat.service.FournisseurService;
import com.gestion.achat.service.OperateurService;
import com.gestion.achat.service.ProduitService;
import com.gestion.achat.service.ReglementService;

@Service
public class FactureServiceImpl implements FactureService{
	
	
	@Autowired
	FactureRepository factureRepository;

	@Autowired
	OperateurService operateurService;
	
	@Autowired
	FournisseurService fournisseurService;
	
	@Autowired
	DetailFactureRepository detailFactureRepository;
	
	@Autowired
	ProduitService produitService;
	
	@Autowired
	ReglementService reglementService;
	
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

	@Override
	public Facture addFacture(Facture f, Long idFournisseur) {
		
		Fournisseur fournisseur = fournisseurService.retrieveFournisseur(idFournisseur);
		List<DetailFacture> detailFactures = detailFactureRepository.findAll();
		
		float montatnFacture = 0;
		float montatnRemiseFacture = 0;
		
		for(DetailFacture detailFacture: detailFactures) {
			Produit produit = produitService.retrieveProduit(detailFacture.getProduit().getIdProduit());
			
			float prixTotalDetail = produit.getPrixUnitaire() * detailFacture.getQte();
			
			float montantRemise = (prixTotalDetail / detailFacture.getPourcentageRemise()) * 100;
			float totalavecremise = prixTotalDetail - montantRemise;
			
			detailFacture.setMontantRemise(totalavecremise);
			detailFacture.setPrixTotal(prixTotalDetail);
			
			montatnFacture = montatnFacture + prixTotalDetail;
			montatnRemiseFacture = montatnRemiseFacture + totalavecremise;
			
		}
		
		f.setMontantFacture(montatnFacture);
		f.setMontantRemise(montatnRemiseFacture);
		f.setFournisseur(fournisseur);
		
		return factureRepository.save(f);
	}

	@Override
	public float pourcentageRecouvrement(Date startDate, Date endDate) {
		float totalReglement = reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate);
		float totalFacture = factureRepository.getTotalFacturesEntreDeuxDates(startDate, endDate);
		float pourcentage = (totalReglement / totalFacture) * 100;
		
		return pourcentage;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
