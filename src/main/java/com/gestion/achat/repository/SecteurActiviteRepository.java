package com.gestion.achat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.achat.entity.SecteurActivite;

@Repository	
public interface SecteurActiviteRepository extends JpaRepository<SecteurActivite, Long> {

}
