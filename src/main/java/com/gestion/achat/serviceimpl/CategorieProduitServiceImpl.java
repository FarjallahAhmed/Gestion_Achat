package com.gestion.achat.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.achat.entity.CategorieProduit;
import com.gestion.achat.repository.CategoriePrduitRepository;
import com.gestion.achat.service.CategorieProduitService;


@Service
public class CategorieProduitServiceImpl implements CategorieProduitService{
	
	@Autowired
	CategoriePrduitRepository categoriePrduitRepository;

	@Override
	public List<CategorieProduit> retrieveAllCategorieProduits() {
		
		List<CategorieProduit> categorieProduits = categoriePrduitRepository.findAll();
		return categorieProduits;
	}

	@Override
	public CategorieProduit addCategorieProduit(CategorieProduit cp) {
		
		return categoriePrduitRepository.save(cp);
	}

	@Override
	public CategorieProduit updateCategorieProduit(CategorieProduit cp) {
		return categoriePrduitRepository.save(cp);
	}

	@Override
	public CategorieProduit retriCategorieProduit(Long id) {
		CategorieProduit categorieProduit = categoriePrduitRepository.findById(id).orElse(null);
		return categorieProduit;
	}

	@Override
	public void deleteCategorieProduit(Long id) {
		CategorieProduit categorieProduit = categoriePrduitRepository.findById(id).orElse(null);
		categoriePrduitRepository.delete(categorieProduit);
		
	}

}
