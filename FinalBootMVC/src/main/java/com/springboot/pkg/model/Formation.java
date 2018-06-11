package com.springboot.pkg.model;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.databind.Module;



public class Formation {

	@Id
	@SequenceGenerator(name = "formationSeq", sequenceName = "formation_seq", allocationSize = 1)
	@GeneratedValue(generator="formationSeq", strategy=GenerationType.SEQUENCE)
	 private Long id;
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

	@ManyToOne
	@JoinColumn(name = "Module")
	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	@OneToMany(mappedBy="stagiaire")
	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
	 
	
	 
}
