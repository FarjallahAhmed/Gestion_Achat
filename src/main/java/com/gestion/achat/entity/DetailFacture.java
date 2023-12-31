package com.gestion.achat.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_DetailFacture")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailFacture implements Serializable{
	

	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDetailFacture; 
	
	
	@Column
	private int qte;
	
	@Column
	private float prixTotal;
	
	@Column
	private float pourcentageRemise;
	
	@Column
	private float montantRemise;
	
	@ManyToOne
	@JoinColumn(name = "factureId")
	@JsonBackReference("facture-detailF")
	private Facture facture;
	
	@ManyToOne
	@JoinColumn(name = "produitId")
	@JsonBackReference("produit-detailF")
	private Produit produit;

}
