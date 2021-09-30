package com.register.pjt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String code;
	private String libelle;
	private String adresse;
	private String tel;
	private String email;
	private String login;
	private String pwd;
	private Date cree;
	
	public Client() {
	}

	public Client(long id, String code, String libelle, String adresse, String tel, String email, String login,
			String pwd, Date cree) {
		
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.login = login;
		this.pwd = pwd;
		this.cree = cree;
	}


	public Client(String code, String libelle, String adresse, String tel, String email, String login, String pwd,
			Date cree) {
		
		this.code = code;
		this.libelle = libelle;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.login = login;
		this.pwd = pwd;
		this.cree = cree;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", code=" + code + ", libelle=" + libelle + ", adresse=" + adresse + ", tel=" + tel
				+ ", email=" + email + ", login=" + login + ", pwd=" + pwd + ", cree=" + cree + "]";
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public Date getCree() {
		return cree;
	}

	public void setCree(Date cree) {
		this.cree = cree;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
