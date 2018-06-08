package com.springboot.pkg.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("O")
public class Ordinateur extends Materiel {
	
	private String processeur;
	private Integer ram;
	private Integer hdd;
	private Date anneeAchat;
	
	public Ordinateur() {
		
	}
	
	public Ordinateur(String processeur, Integer ram, Integer hdd, Date anneeAchat) {
		this.processeur = processeur;
		this.ram = ram;
		this.hdd = hdd;
		this.anneeAchat = anneeAchat;
	}

	public String getProcesseur() {
		return processeur;
	}

	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	public Integer getHdd() {
		return hdd;
	}

	public void setHdd(Integer hdd) {
		this.hdd = hdd;
	}

	public Date getAnneeAchat() {
		return anneeAchat;
	}

	public void setAnneeAchat(Date anneeAchat) {
		this.anneeAchat = anneeAchat;
	}
	
	
	

}
