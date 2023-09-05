package com.gestion.achat.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_CategorieProduit")
public class CategorieProduit implements Serializable{
	
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCategorieProduit;
	
	@Column
	private String codeProduit;
	
	@Column
	private String libelleCategorieProduit;
	
	@OneToMany(mappedBy = "categorieProduit")
	private Set<Produit> produits;
	
	

}
