package com.gestion.achat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.achat.entity.DetailFournisseur;

@Repository
public interface DetailFournisseurRepository extends JpaRepository<DetailFournisseur, Long> {

}
