package com.gestion.achat.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_DetailFournisseur")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailFournisseur implements Serializable{
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDetailFournisseur;
	
	
	@Column
	private Date dateDEbutCollaboration;
	
	@Column
	private String adresse;
	
	@Column
	private String matricule;
	
	@OneToOne(mappedBy = "detailFournisseur")
	@JsonManagedReference("detailF-fournisseur")
	private Fournisseur fournisseur;
	
	

}
