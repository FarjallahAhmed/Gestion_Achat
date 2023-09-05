package com.gestion.achat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.achat.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
