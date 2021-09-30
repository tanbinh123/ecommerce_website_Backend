package com.register.pjt.Dto;

public class ListArticle {
	  private String code;
	  private String libelle;
	  private String scateg;
	  private String categ;
	  private double pa;
	  private double pv;
	  private int tva;
	  private int stock;
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
	public String getCscateg() {
		return scateg;
	}
	public void setCscateg(String cscateg) {
		this.scateg = cscateg;
	}
	public String getCcateg() {
		return categ;
	}
	public void setCcateg(String ccateg) {
		this.categ = ccateg;
	}
	public double getPa() {
		return pa;
	}
	public void setPa(double pa) {
		this.pa = pa;
	}
	public double getPv() {
		return pv;
	}
	public void setPv(double pv) {
		this.pv = pv;
	}
	public int getTva() {
		return tva;
	}
	public void setTva(int tva) {
		this.tva = tva;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public ListArticle(String code, String libelle, String scateg, String categ, double pa, double pv, int tva,
			int stock) {
		
		this.code = code;
		this.libelle = libelle;
		this.scateg = scateg;
		this.categ = categ;
		this.pa = pa;
		this.pv = pv;
		this.tva = tva;
		this.stock = stock;
	}
	 
	  
}
