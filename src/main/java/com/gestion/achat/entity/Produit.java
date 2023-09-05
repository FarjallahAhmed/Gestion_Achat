package com.gestion.achat.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Produit")
public class Produit implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduit;
	
	@Column
	private String codeProduit;
	
	@Column
	private String libelleProduit;
	
	@Column
	private float prixUnitaire;
	
	@Column
	private Date dateCreation;
	
	@Column
	private Date dateDerniereModification;
	
	
	@OneToMany(mappedBy = "produit")
	private Set<DetailFacture> detailFactures;
	
	@ManyToOne
	@JoinColumn(name = "stockId")
	private Stock stock;
	
	@ManyToOne
	@JoinColumn(name = "categorieId")
	private CategorieProduit categorieProduit;
}
