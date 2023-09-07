package com.gestion.achat.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_Client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idClient;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column 
	private Date dateNaissance;
	
	@Column
	private String email;
	
	@Column 
	private String password;
	
	@Enumerated(EnumType.ORDINAL) 
	private CategorieClient categorieClient;
	
	@Enumerated(EnumType.ORDINAL)
	private Profession profession;

}
