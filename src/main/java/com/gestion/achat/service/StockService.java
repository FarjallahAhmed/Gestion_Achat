package com.gestion.achat.service;

import java.util.List;

import com.gestion.achat.entity.Stock;

public interface StockService {
	
	List<Stock> retrieveAllStock();
	Stock addStockd(Stock s);
	void deleteStock(Long id);
	Stock updateStock(Stock s);
	Stock retrieveStock(Long id);

}
