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
@Table(name = "T_Stock")
public class Stock implements Serializable {

	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStock;
	
	@Column
	private int qteStock;
	
	@Column
	private int qteMin;
	
	@Column
	private String libelleStock;
	
	@OneToMany(mappedBy = "stock")
	private Set<Produit> produits;
}
