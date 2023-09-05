package com.gestion.achat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.achat.entity.Operateur;

@Repository
public interface OperateurRepository extends JpaRepository<Operateur, Long> {

}
