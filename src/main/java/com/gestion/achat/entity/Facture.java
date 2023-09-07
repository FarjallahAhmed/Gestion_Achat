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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_Facture")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Facture implements Serializable{
	
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFacture;
	
	
	@Column
	private float montantRemise;
	
	@Column
	private float montantFacture;
	
	@Column
	private Date dateCreationFacture;
	

	@Column
	private Date dateDeriereModification;
	
	@Column
	private boolean active;
	
	
	@OneToMany(mappedBy="facture")
	private Set<Reglement> reglements;
	
	@OneToMany(mappedBy = "facture")
	private Set<DetailFacture> detailFactures;
	
	@ManyToOne
	@JoinColumn(name = "fournisseurId")
	private Fournisseur fournisseur;
	
	

}
