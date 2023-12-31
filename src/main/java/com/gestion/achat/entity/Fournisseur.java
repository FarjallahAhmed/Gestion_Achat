package com.gestion.achat.entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_Fournisseur")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	@JsonManagedReference("fourenisseur-facture")
	private Set<Facture> factures;
	
	@OneToOne
	@JsonBackReference("detailF-fournisseur")
	private DetailFournisseur detailFournisseur;
	
	@ManyToMany
	private Set<SecteurActivite> activites;
	

}
