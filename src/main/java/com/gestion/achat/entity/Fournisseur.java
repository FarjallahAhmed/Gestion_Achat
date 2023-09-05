package com.gestion.achat.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Fournisseur")
public class Fournisseur implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFournisseur;
	
	@Column
	private String codeFournisseur;
	
	@Column
	private String libelleFournissseur;
	
	@Enumerated(EnumType.ORDINAL)
	private CategorieFournisseur categorieFournisseur;
	
	@OneToMany(mappedBy = "fournisseur")
	private Set<Facture> factures;
	
	@OneToOne
	private DetailFournisseur detailFournisseur;
	
	@ManyToMany
	private Set<SecteurActivite> activites;
	

}
