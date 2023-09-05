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
@Table(name = "T_Operateur")
public class Operateur implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOperateur;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String password;
	
	
	@OneToMany
	private Set<Facture> factures;
	
	
	
}
