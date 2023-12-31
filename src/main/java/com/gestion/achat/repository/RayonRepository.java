package com.gestion.achat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.achat.entity.Rayon;

@Repository
public interface RayonRepository extends JpaRepository<Rayon, Long> {

}
