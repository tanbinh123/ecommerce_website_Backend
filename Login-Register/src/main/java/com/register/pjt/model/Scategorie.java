package com.register.pjt.model;

import javax.persistence.*;

@Entity
@Table(name = "scategorie")
public class Scategorie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String code;
	private String libelle;
	private String ccateg;
	private int rang;
	
	  
	public Scategorie() {
	}

	public Scategorie(long id, String code, String libelle, String ccateg, int rang) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.ccateg = ccateg;
		this.rang = rang;
	}

	public Scategorie(String code, String libelle, String ccateg, int rang) {
		this.code = code;
		this.libelle = libelle;
		this.ccateg = ccateg;
		this.rang = rang;
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

	public String getCcateg() {
		return ccateg;
	}

	public void setCcateg(String ccateg) {
		this.ccateg = ccateg;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	@Override
	public String toString() {
		return "Scategorie [id=" + id + ", code=" + code + ", libelle=" + libelle + ", ccateg=" + ccateg + ", rang="
				+ rang + "]";
	}


	
}
