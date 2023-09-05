package com.gestion.achat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.achat.entity.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
}