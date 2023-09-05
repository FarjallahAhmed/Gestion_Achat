package com.gestion.achat.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Reglement")
public class Reglement implements Serializable{

	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idreglement;
	
	@Column
	private float montantPaye;
	
	@Column
	private float montantRestant;
	
	@Column
	private boolean payee;
	
	@Column
	private Date dateReglement;
	
	@ManyToOne
	@JoinColumn(name = "factureId")
	private Facture facture;
	
}
