package com.springboot.pkg.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "S")
public class Stagiaire extends RH {

	private Ordinateur ordinateur;
	private Formation formation;
	public Stagiaire() {

	}

	@OneToOne
	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	@ManyToOne
	@JoinColumn(name = "formation")
	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	
}
