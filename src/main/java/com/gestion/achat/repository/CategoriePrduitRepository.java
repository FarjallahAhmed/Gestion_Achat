package com.gestion.achat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.achat.entity.CategorieProduit;

@Repository
public interface CategoriePrduitRepository extends JpaRepository<CategorieProduit, Long> {

}
