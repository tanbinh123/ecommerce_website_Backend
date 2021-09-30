package com.register.pjt.model;

import javax.persistence.*;

@Entity
@Table(name = "categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String code;
	private String libelle;
	
	public Categorie() {
	
	}

	public Categorie(long id, String code, String libelle) {
		
		this.id = id;
		this.code = code;
		this.libelle = libelle;
	}

	public Categorie(String code, String libelle) {
		
		this.code = code;
		this.libelle = libelle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
	}
	
	
	
	
	
	
}
