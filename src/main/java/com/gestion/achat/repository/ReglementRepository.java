package com.gestion.achat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.achat.entity.Reglement;

@Repository
public interface ReglementRepository extends JpaRepository<Reglement,Long> {

}
