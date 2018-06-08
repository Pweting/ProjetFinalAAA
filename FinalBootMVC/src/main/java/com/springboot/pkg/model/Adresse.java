package com.springboot.pkg.model;

import javax.persistence.Embeddable;


@Embeddable
public class Adresse {

	private Integer num;
	private Integer cp;
	private String rue;
	private String ville;
	private String pays;
	
	
	public Adresse() {
		
	}


	public Adresse(Integer num, Integer cp, String rue, String ville, String pays) {
	
		this.num = num;
		this.cp = cp;
		this.rue = rue;
		this.ville = ville;
		this.pays = pays;
	}


	public Integer getNum() {
		return num;
	}


	public void setNum(Integer num) {
		this.num = num;
	}


	public Integer getCp() {
		return cp;
	}


	public void setCp(Integer cp) {
		this.cp = cp;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
}
