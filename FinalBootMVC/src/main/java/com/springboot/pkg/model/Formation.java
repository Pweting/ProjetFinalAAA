package com.springboot.pkg.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.databind.Module;

@Entity
public class Formation {

	@Id
	@SequenceGenerator(name = "formationSeq", sequenceName = "formation_seq", allocationSize = 1)
	@GeneratedValue(generator = "formationSeq", strategy = GenerationType.SEQUENCE)
	private Long id;
	private Date date_debut;
	private Date date_fin;

	
<<<<<<< HEAD
=======
	@OneToMany (mappedBy = "formation")	
	private List<Module> modules;
	
>>>>>>> master
	@OneToMany(mappedBy="formation")
	private List<Stagiaire> stagiaires;

	public Formation() {

	}

	public Long getId() { 
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	 

}
