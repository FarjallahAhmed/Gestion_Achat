package com.gestion.achat.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.achat.entity.Stock;
import com.gestion.achat.repository.StockRepository;
import com.gestion.achat.service.StockService;


@Service
public class StockServiceImpl implements StockService{
	
	
	@Autowired
	private StockRepository stockRepository;
	

	@Override
	public List<Stock> retrieveAllStock() {
		List<Stock> listStocks = stockRepository.findAll();
		return listStocks;
	}

	@Override
	public Stock addStockd(Stock s) {
		
		return stockRepository.save(s);
	}

	@Override
	public void deleteStock(Long id) {
		Stock s = stockRepository.findById(id).orElse(null);
		stockRepository.delete(s);
	}

	@Override
	public Stock updateStock(Stock s) {
		
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long id) {
		Stock s = stockRepository.findById(id).orElse(null);
		return s;
	}

}
