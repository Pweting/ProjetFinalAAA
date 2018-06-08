package com.springboot.pkg.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.Module;



public class Formation {

	 
	 private Date date_debut;
	 private Date date_fin;
	 private List<Module> modules;
	 private List<Stagiaire> stagiaires;
	 
	public Formation() {
	
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
	 
	
	 
}
