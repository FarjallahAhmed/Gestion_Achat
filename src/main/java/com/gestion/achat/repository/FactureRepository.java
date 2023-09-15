package com.gestion.achat.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestion.achat.entity.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
	
	@Query("SELECT sum(f.montantFacture) FROM Facture f where  f.dateCreationFacture between :startDate and :endDate and f.active=false")
	float getTotalFacturesEntreDeuxDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
