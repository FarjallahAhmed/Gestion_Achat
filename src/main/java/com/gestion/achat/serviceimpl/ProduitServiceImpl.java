package com.gestion.achat.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.achat.entity.CategorieProduit;
import com.gestion.achat.entity.Produit;
import com.gestion.achat.entity.Stock;
import com.gestion.achat.repository.ProduitRepository;
import com.gestion.achat.service.CategorieProduitService;
import com.gestion.achat.service.ProduitService;
import com.gestion.achat.service.StockService;


@Service
public class ProduitServiceImpl implements ProduitService{

	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	CategorieProduitService categorieProduitService;
	
	@Autowired
	StockService stockService;
	
	
	
	@Override
	public List<Produit> retrieveAllProduits() {
		return produitRepository.findAll();
	}

	@Override
	public Produit addProduit(Produit p, Long idCategorieProduit, Long idStock) {
		
		CategorieProduit categorieProduit = categorieProduitService.retriCategorieProduit(idCategorieProduit);
		Stock stock = stockService.retrieveStock(idStock);
		
		p.setCategorieProduit(categorieProduit);
		p.setStock(stock);
		
		return  produitRepository.save(p);
	}

	@Override
	public Produit updateProduit(Produit p, Long idCategorieProduit, Long idStock) {
		CategorieProduit categorieProduit = categorieProduitService.retriCategorieProduit(idCategorieProduit);
		Stock stock = stockService.retrieveStock(idStock);
		
		p.setCategorieProduit(categorieProduit);
		p.setStock(stock);
		
		return  produitRepository.save(p);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		
		return produitRepository.findById(id).orElse(null);
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		
		Stock stock = stockService.retrieveStock(idStock);
		Produit produit = produitRepository.findById(idProduit).orElse(null);
		
		produit.setStock(stock);
		produitRepository.save(produit);
		//stock.getProduits().add(produit);
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
