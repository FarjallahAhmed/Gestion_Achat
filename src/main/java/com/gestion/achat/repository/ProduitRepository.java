package com.gestion.achat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.achat.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
