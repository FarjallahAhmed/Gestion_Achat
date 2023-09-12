package com.gestion.achat.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestion.achat.entity.Reglement;

@Repository
public interface ReglementRepository extends JpaRepository<Reglement,Long> {

	
	@Query("SELECT r FROM Reglement r where r.facture.idFacture =:idFacture")
	List<Reglement> retrieveReglementByFacture(@Param("idFacture") Long idFacture);
	
	
	@Query("SELECT sum(r.montantPaye) FROM Reglement r where r.dateReglement between :sDate AND :eDate and r.facture.active=false")
	float getChiffreAffaireEntreDeuxDate(@Param("sDate") Date startDate, @Param("eDate") Date endDate);
}
