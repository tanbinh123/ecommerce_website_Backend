package com.register.pjt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//@Entity
@Table(name = "fournisseur")
public class Fournisseur {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String libelle;
	private String adresse;
	private String tel;
	private String email;
	private String login;
	private String pwd;
	private String  matfisc;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMatfisc() {
		return matfisc;
	}
	public void setMatfisc(String matfisc) {
		this.matfisc = matfisc;
	}
	public Fournisseur() {
		
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(long id, String libelle, String adresse, String tel, String email, String login, String pwd,
			String matfisc) {
		
		this.id = id;
		this.libelle = libelle;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.login = login;
		this.pwd = pwd;
		this.matfisc = matfisc;
	}
	public Fournisseur(String libelle, String adresse, String tel, String email, String login, String pwd,
			String matfisc) {
		
		this.libelle = libelle;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.login = login;
		this.pwd = pwd;
		this.matfisc = matfisc;
	}
	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", libelle=" + libelle + ", adresse=" + adresse + ", tel=" + tel + ", email="
				+ email + ", login=" + login + ", pwd=" + pwd + ", matfisc=" + matfisc + "]";
	}
	
	
	
	
}
