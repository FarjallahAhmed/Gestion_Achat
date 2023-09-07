package com.gestion.achat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.achat.service.StockService;


import io.swagger.v3.oas.annotations.responses.ApiResponse;

import com.gestion.achat.entity.Stock;
@RestController
public class StockController {

	@Autowired
	StockService stockService;
	
	
	@GetMapping("/retrieve-all-stocks")
	@ApiResponse(description = "return the stock list from the database")
	public List<Stock> getStocks(){
		
		return stockService.retrieveAllStock();
	}
	
	@PostMapping("/add-stock")
	public Stock addStock(@RequestBody Stock s) {
		
		return stockService.addStockd(s);
	}
	
	
	@PutMapping("/update-stock")
	public Stock updateStock(@RequestBody Stock s) {
		
		return stockService.updateStock(s);
	}
	
	
}
