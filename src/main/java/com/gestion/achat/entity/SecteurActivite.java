package com.gestion.achat.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_SecteurActivite")
public class SecteurActivite implements Serializable {

	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSecteurActivite;
	
	
	@Column
	private String codeSecteurActivite;
	
	@Column
	private String libelleSecteurActivite;
	
	@ManyToMany(mappedBy = "activites")
	private Set<Fournisseur> fournisseurs;
}
