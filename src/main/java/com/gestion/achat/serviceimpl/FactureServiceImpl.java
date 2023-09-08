package com.gestion.achat.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.achat.entity.Facture;
import com.gestion.achat.repository.FactureRepository;
import com.gestion.achat.service.FactureService;

@Service
public class FactureServiceImpl implements FactureService{
	
	
	@Autowired
	FactureRepository factureRepository;

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

}
